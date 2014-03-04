package com.tisson.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisson.common.platform.invoker.bean.IParamGroup;
import com.tisson.common.platform.invoker.bean.ParamGroupImpl;
import com.tisson.common.platform.invoker.caller.IServiceCall;
import com.tisson.common.platform.invoker.caller.ServiceCallImpl;
import com.tisson.common.platform.provider.server.PackageDataSet;
import com.tisson.common.utils.ChannelCode;
import com.tisson.common.utils.Charset;
import com.tisson.common.utils.MathTool;
import com.tisson.common.utils.exception.INFException;
import com.tisson.common.utils.exception.InfError;
import com.tisson.dao.bis.CumAcctMapper;
import com.tisson.dao.bis.CumInfoMapper;
import com.tisson.webservice.rest.domain.PhoneRechargeRequert;
import com.tisson.webservice.rest.domain.ShortcutTrader;

/**
 * svc inf2011
 * 
 * @author wanght 2013-12-05 <br>
 *         TODO 话费充值(纯业务)
 * 
 */
@Service
public class PhoneRechargeService extends
		AbstractInfService<PhoneRechargeRequert> {

	@Autowired
	private CumInfoMapper cumInfoMapper;

	@Autowired
	private CumAcctMapper cumAcctMapper;

	public void getShortcatTrader(PhoneRechargeRequert request,
			ShortcutTrader response) throws INFException {
		String custId = request.getCustCode();
		// // 插入信息到入站日志表
		this.insertInfOperInLog(request);
		// 检验商户
		this.checkCustCode(request);
		// md5效验
		this.verifyByMD5(request);

		// if (Double.valueOf(request.getTxnAmount()) < 1) {
		// throw new Exception("金额不能少于1分钱");
		// }
		// 对时间格式进行匹配 时间格式：yyyyMMddHHmmss
		// if (!(request.getTradeTime().matches(RegexTool.DATE_FORMAT))) {
		//
		// throw new Exception("输入日期格式不正确");
		// }

		// IPOS处理
		// 密码鉴权
		// PasswordUtil.AuthenticationPassWord1(request, request.getStaffCode(),
		// request.getPayPassword(), request.getECardNo(),
		// request.getPsamCardNo(), request.getPassFlag());

		Map<String, String> map = cumInfoMapper
				.getCustCodeByExtTermNumNo(request.getTmnNum());
		if (map != null && map.size() != 0) {
			String custCode = map.get("CUST_CODE");
			String tmnNumNo = map.get("TERM_CODE");
			request.setCustCode(custCode);
			request.setTmnNum(tmnNumNo);
		} else {
			throw new INFException(InfError.CustCodeNotMatch.getCode(),
					InfError.CustCodeNotMatch.getReason());
		}

		// 关联机构验证
		String merId = request.getMerId();
		// String merIdByCustCode = cumInfoMapper.getMerIdByCustCode(request
		// .getCustCode());
		// if (!merId.equals(merIdByCustCode)) {
		//
		// throw new INFException(
		// InfError.CustCodeNotMatchMegerDesc.getCode(),
		// InfError.CustCodeNotMatchMegerDesc.getReason());
		// }

		// 判断有无交易查询权限
		// List privList = PayCompetenceManage.payFunc(request.getCustCode());
		// boolean r = false;
		// for (int i = 0; i < privList.size(); i++) {
		// Map map = (Map) privList.get(i);
		// String str = map.get("PRIV_URL").toString();
		//
		// if (PrivConstant.IPOS_RECHARGE_TELFARE.equals(str)) {
		// r = true;
		// break;
		// }
		//
		// }

		// if (!r) {
		// throw new Exception("你没有话费充值的权限");
		// }

		PackageDataSet ds = null;

		String resultCode = "";

		String responseDesc = "";

		if (ChannelCode.IPOS_CHANELCODE.equals(request.getChannelCode())
				|| "9".equals(request.getPayType())) {

			Hashtable<String, Object> m = process2(request);

			resultCode = (String) m.get("ResultCode");

			responseDesc = (String) m.get("ResponseDesc");

			ds = (PackageDataSet) m.get("DateSet");

		}

		String transSeq = ds.getByID("4002", "401");

		String txanAmount = "";

		ArrayList list = ds.getParamByID("6303", "600");

		if (list != null && list.size() != 0) {

			String txanAmounts = (String) list.get(0);// 交易金额
			// 单位转换：元转分
			txanAmount = MathTool.yuanToPoint(txanAmounts);
		} else {

			txanAmount = MathTool.yuanToPoint(request.getTxnAmount());
		}

		// // 插入信息到出站日志表
		this.insertInfOperInLog(request);
	}

	@Override
	protected Class<?> getFeaturedClass() {
		return this.getClass();
	}

	private  Hashtable<String, Object> process2(
			PhoneRechargeRequert request) {

		PackageDataSet ds = null;

		String responseDesc = "";

		String resultCode = "";

		String payAmount = request.getTxnAmount();

		// 单位转换：分转元
		String reAmount = MathTool.pointToYuan(request.getRechargeAmount());

		String txAmount = MathTool.pointToYuan(payAmount);

		request.setRechargeAmount(reAmount);

		request.setTxnAmount(txAmount);
		// 充值
		ds = recharge(request, payAmount, null);

		resultCode = (String) ds.getParamByID("0001", "000").get(0);

		// 返回结果为失败时，获取结果描述
		if (Long.valueOf(resultCode) == 0) {

			responseDesc = (String) ds.getParamByID("0002", "000").get(0);
		}

		Hashtable<String, Object> map = new Hashtable<String, Object>();

		map.put("ResultCode", resultCode);

		map.put("ResponseDesc", responseDesc);

		map.put("PayAmount", payAmount);

		map.put("DateSet", ds);

		return map;

	}

	/**
	 * 调用SCS0001接口充值
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private  PackageDataSet recharge(PhoneRechargeRequert request,
			String payAmount, String concession) {

		String acctCode = cumAcctMapper.getAcctCode(request.getCustCode());// 银行帐号
		String bankCode = cumAcctMapper.getBankCode(acctCode); // 银行编码[通过银行帐号查询]
		String rechargeType = request.getRechargeType();// 业务编码

		// 通过客户编码查区域编码
		String area_code = TCumInfoDao.getAreaCode(request.getCustCode());
		String provinceCode = TCumInfoDao.getProvinceCodeByPhoneNum(request
				.getPhone());// 手机号对应的省份编码
		if (Charset.isEmpty(provinceCode, true)) {// 查不到，用企业账户的区域编码
			provinceCode = area_code;
		}

		bankCode = "110000";

		String newActionCode = rechargeType;

		// 单位转换：分转元
		payAmount = MathTool.pointToYuan(payAmount);
		concession = MathTool.pointToYuan(concession);

		/**
		 * 调用SCS0001,完成交易操作
		 */
		// 订单受理信息
		IParamGroup g401 = new ParamGroupImpl("401");
		g401.put("4004", request.getCustCode());// 客户编码
		g401.put("4005", "OT001");// 订单类型编码：业务类订单
		// g401.put("4006", areaCode);// 所属区域编码
		g401.put("4006", area_code);// 所属区域编码 杭州330100
		g401.put("4007", request.getTmnNum());// 受理终端号
		g401.put("4008", request.getTradeTime());// 受理时间
		g401.put("4012",convertCodeToChar(request.getRechargeType(),
						request.getPayType()));// 订单描述
		g401.put("4016", "LG001");// 客户登录认证方式编码：用户名
		g401.put("4144", request.getChannelCode60To20());// 渠道类型编码
		// g401.put("4017", request.getOrderNo());// 订单号？？？
		g401.put("4017", request.getKeep());// 订单号？？？
		g401.put("4018", request.getTmnNum());// 操作原始来源
		g401.put("4028", request.getOrderNo());

		g401.put("4284", request.getMerId());// 机构编码 //20130628 wanght
		g401.endRow();

		// 订单费用信息
		IParamGroup g402 = new ParamGroupImpl("402");
		g402.put("4021", "0001");// 币种编码
		g402.put("4023", request.getTxnAmount());// 订单原始金额
		g402.put("4024", "0");// 订单优惠金额
		g402.put("4025", payAmount);// 订单应付金额
		g402.put("4030", concession);// 溢价
		g402.endRow();

		// 业务单信息
		IParamGroup g404 = new ParamGroupImpl("404");
		g404.put("4047", "1");// 业务单序号
		g404.put("4049", getProductCode(rechargeType));// 产品编码
		g404.put("4051", newActionCode);// 业务编码
		g404.put("4052", request.getPhone());// 业务对象
		g404.put("4053", "1");// 业务数量
		g404.put("4062", "");// 当该值与不为空时，已该值作为actlist的系统参考号。否则由核心交易平台平台生成
		g404.put("4072", rechargeType);
		g404.endRow();

		// 业务单费用信息
		IParamGroup g405 = new ParamGroupImpl("405");
		g405.put("4047", "1");// 业务单序号
		g405.put("4021", "0001");// 币种编码
		g405.put("4066", request.getTxnAmount());// 业务单原始金额
		g405.put("4067", "0");// 业务单优惠金额
		g405.put("4068", request.getTxnAmount());// 业务单应付金额
		g405.put("4071", "103");// 费用项标识
		g405.endRow();

		// 业务属性信息
		IParamGroup g407 = new ParamGroupImpl("407");
		g407.put("4047", "1");// 业务单序号
		g407.put("4051", newActionCode);// 业务编码
		g407.put("4087", "SCS_DEALTYPE");
		g407.put("4088", "0200");
		g407.put("4089", "");
		g407.put("4091", "");
		g407.put("4093", "");
		g407.put("4080", "0");// 控制标识
		g407.endRow();

		g407.put("4047", "1");// 业务单序号
		g407.put("4051", newActionCode);// 业务编码
		g407.put("4087", "SCS_USERTYPE");
		g407.put("4088", "1");
		g407.put("4089", "");
		g407.put("4091", "");
		g407.put("4093", "");
		g407.put("4080", "0");// 控制标识
		g407.endRow();

		g407.put("4047", "1"); // 业务单序号
		g407.put("4051", newActionCode); // 业务编码
		g407.put("4087", "SCS_DISCID"); // 产品属性编码
		g407.put("4088", newActionCode + provinceCode); // 附加项数据类型
		g407.put("4089", "");
		g407.put("4091", "");
		g407.put("4093", "");
		g407.put("4080", "0"); // 控制标识
		g407.endRow();

		g407.put("4047", "1");// 业务单序号
		g407.put("4051", newActionCode);// 业务编码
		g407.put("4087", "SCS_SERVID");
		g407.put("4088", get4088Param(rechargeType));
		g407.put("4080", "0");// 控制标识
		g407.endRow();

		// 支付单信息
		IParamGroup g408 = new ParamGroupImpl("408");
		g408.put("4103", "1");// 扣款顺序号
		if ("9".equals(request.getPayType())) {
			g408.put("4097", "PT2001");// 支付方式编码
		} else {
			g408.put("4097", "PT0004");// 支付方式编码
		}
		g408.put("4127", bankCode);// 前置支付机构,查卡表的bankcode
		g408.put("4098", bankCode);// 支付机构编码
		g408.put("4099", "0007");// 账户类型编码
		g408.put("4101", acctCode);// 账号
		g408.put("4102", request.getPayPassword());// 支付密码
		g408.put("4021", "0001");// 币种编码
		g408.put("4104", payAmount);// 支付金额
		g408.put("4109", "0003");// 国际网络号
		g408.put("4119", "");
		g408.endRow();

		// 组成数据包,调用SCS0001接口
		IServiceCall caller = new ServiceCallImpl();
		PackageDataSet dataSet = caller.call("SCS", "SCS0001", g401, g402,
				g404, g405, g407, g408);

		// 返回结果
		return dataSet;

	}

}

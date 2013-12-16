package com.tisson.service.shortcutTrader;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisson.common.utils.algorithm.MD5;
import com.tisson.common.utils.exception.INFErrorDef;
import com.tisson.common.utils.exception.INFException;
import com.tisson.dao.bis.CumCustomMapper;
import com.tisson.dao.bis.CumInfoMapper;
import com.tisson.dao.bis.SysParamMapper;
import com.tisson.dao.inf.LoginLogMapper;
import com.tisson.dao.inf.OperInLogMapper;
import com.tisson.dao.inf.OperOutLogMapper;
import com.tisson.entity.inf.OperInLog;
import com.tisson.webservice.rest.domain.ShortcutTraderRequert;
import com.tisson.webservice.rest.domain.ShortcutTraderResponse;

@Service
public class ShortcutTraderService {

	@Autowired
	SysParamMapper sysParamMapper;
	@Autowired
	LoginLogMapper loginLogMapper;
	@Autowired
	OperInLogMapper operInLogMapper;
	@Autowired
	OperOutLogMapper operOutLogMapper;
	// 业务组件
	@Autowired
	CumInfoMapper cumInfoMapper;
	@Autowired
	CumCustomMapper cumCustomMapper;

	public ShortcutTraderResponse getShortcatTrader(ShortcutTraderRequert trader)
			throws INFException {
		ShortcutTraderResponse response = new ShortcutTraderResponse();
		OperInLog operInLog = null;
		// 客户端MD5校验--------------------------------------------
		String tokenValidTime = sysParamMapper.getValByCode("TOKEN_VALIDTIME");
		String md5Key = loginLogMapper.getMD5KeyByStaffCode(
				trader.getStaffCode(), tokenValidTime);
		String cer = trader.getCer();
		if (StringUtils.isNotEmpty(cer)) {
			response.setCer(md5Key);
			String md5Str = MD5.MD5Encode(cer);
			if (!md5Str.equals(trader.getSign())) {
				throw new INFException(INFErrorDef.MD5_SIGN_VAREFY_FAIL,
						"SIGN验证无效");
			}
		}
		loginLogMapper.updateRanduseTimeByStaffCode(trader.getStaffCode());
		// -------------------------------------------------------------------

		// 插入信息到入站日志表
		operInLog = operInLogMapper.insert(trader);
		// 判断插入是否成功
		if (operInLog != null) {
			boolean flag = operInLogMapper.selectTInfOperInLogByKeep(trader
					.getKeep());
			// 判断流水号是否可用
			if (flag) {
				flag = operInLogMapper.updateAllow(operInLog.getOperInId(), 1);
				throw new INFException(INFErrorDef.POSSEQNO_CONFLICT_CODE,
						INFErrorDef.POSSEQNO_CONFLICT_REASON);
			} else {
				flag = operInLogMapper.updateAllow(operInLog.getOperInId(), 0);
			}
		}

		// 获取客户ID
		String custId = cumInfoMapper.getCustIdByCode(trader.getCustCode());
		if (custId == null) {
			// response.setCode(INFErrorDef.);
			String msg = "该商户号不存在";
			response.setContent(msg);
			return response;
		}

		// 单笔交易
		String perAmount = cumCustomMapper.getSingleTrader(custId, "T22",
				"TH004");
		// 累计交易
		String allAmount = cumCustomMapper.getSingleTrader(custId, "T22",
				"TH005");
		// 当月累计消费
		String allTrade = cumCustomMapper.getAmountCount(custId);

		response.setPerAmount(perAmount);
		response.setAllamount(allAmount);
		response.setAlltransaction(allTrade);
		// 插入信息到出站日志表
		operOutLogMapper.insert(trader);

		return response;
	}

}

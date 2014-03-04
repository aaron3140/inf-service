package com.tisson.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.common.utils.algorithm.MD5;
import com.tisson.common.utils.exception.INFErrorDef;
import com.tisson.common.utils.exception.INFException;
import com.tisson.dao.bis.CumInfoMapper;
import com.tisson.dao.bis.SysParamMapper;
import com.tisson.dao.inf.LoginLogMapper;
import com.tisson.dao.inf.OperInLogMapper;
import com.tisson.dao.inf.OperOutLogMapper;
import com.tisson.entity.inf.OperInLog;
import com.tisson.webservice.rest.domain.CommonRequest;

public abstract class AbstractInfService<M extends CommonRequest> {

	@Autowired
	SysParamMapper sysParamMapper;
	@Autowired
	LoginLogMapper loginLogMapper;
	@Autowired
	OperInLogMapper operInLogMapper;
	@Autowired
	OperOutLogMapper operOutLogMapper;
	@Autowired
	CumInfoMapper cumInfoMapper;

	public final Log log = LogFactory.getLog(this.getFeaturedClass());

	/**
	 * 检验商户号是否一致
	 * @param request
	 * @throws INFException
	 */
	protected void checkCustCode(M request) throws INFException {
		String custCode = request.getCustCode();
		String custId = cumInfoMapper.getCustIdByCode(custCode);
		if (custId == null) {
			String msg = "该商户号不存在";
			throw new INFException("019999", msg);
		}
		if (StringUtils.isNotEmpty(custCode)) {
			if (!StringUtils.equals(custId, custCode)) {
				throw new INFException(INFErrorDef.CUSTCODE_NOT_EXIST,
						INFErrorDef.CUSTCODE_NOT_MATCH_STAFF_DESC);
			}
		} else {
			request.setCustCode(custId);
		}
	}

	protected void insertInfOperInLog(M request) throws INFException {
		// 插入信息到入站日志表
		OperInLog operInLog = operInLogMapper.insert(request);
		// 判断插入是否成功
		if (operInLog != null) {
			boolean flag = operInLogMapper.selectTInfOperInLogByKeep(request
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
	}

	protected void verifyByMD5(CommonRequest request) throws INFException {
		// 客户端MD5校验--------------------------------------------
		String tokenValidTime = sysParamMapper.getValByCode("TOKEN_VALIDTIME");
		String md5Key = loginLogMapper.getMD5KeyByStaffCode(
				request.getStaffCode(), tokenValidTime);
		String cer = request.getCer();
		if (StringUtils.isNotEmpty(cer)) {
			String md5Str = MD5.MD5Encode(cer + md5Key);
			if (!md5Str.equals(request.getSign())) {
				throw new INFException(INFErrorDef.MD5_SIGN_VAREFY_FAIL,
						"SIGN验证无效");
			}
		}
		loginLogMapper.updateRanduseTimeByStaffCode(request.getStaffCode());
	}
	
	/**
	 * 接收子类具体
	 * 
	 * @return
	 */
	protected abstract Class<?> getFeaturedClass();

}
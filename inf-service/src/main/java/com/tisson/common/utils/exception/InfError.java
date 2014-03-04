/**
 * 
 */
package com.tisson.common.utils.exception;

/**
 * @author aaronMing
 *
 */
public enum InfError {

	OrderNotExist("010013","订单不存在"),
//	FiledInvalid("019998","字段验证无效"),
	CustCodeNotMatchMegerDesc("019996","不是当前机构下的企业账户或设定关系中的机构"),
	
	CustCodeNotMatch("019997","该外部终端号找不到客户"),
	
	FiledInvalid("019998","字段验证无效");

	InfError(String code,String reason){
		this.code=code;
		this.reason=reason;
	}
	

	String code, reason;
	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}
}

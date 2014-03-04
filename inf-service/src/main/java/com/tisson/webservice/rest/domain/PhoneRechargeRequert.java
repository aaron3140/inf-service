package com.tisson.webservice.rest.domain;



public class PhoneRechargeRequert extends CommonRequest {

	
	
	private String payType;
	private String psamCardNo;
	private String eCardNo;
	private String passFlag;
	private String payPassword;
	private String rechargeType;
	private String phone;
	private String rechargeAmount;
	private String txnAmount;
	private String tradeTime;
	
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPsamCardNo() {
		return psamCardNo;
	}
	public void setPsamCardNo(String psamCardNo) {
		this.psamCardNo = psamCardNo;
	}
	public String geteCardNo() {
		return eCardNo;
	}
	public void seteCardNo(String eCardNo) {
		this.eCardNo = eCardNo;
	}
	public String getPassFlag() {
		return passFlag;
	}
	public void setPassFlag(String passFlag) {
		this.passFlag = passFlag;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public String getRechargeType() {
		return rechargeType;
	}
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(String rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public String getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	
	
}

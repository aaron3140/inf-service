package com.tisson.entity.inf;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * 本类描述: 
 * 
 * @version: 企业帐户前置接口 v1.0
 * @author: 广州天讯瑞达通讯技术有限公司(zhuxiaojun)
 * @email: zhuxiaojun@tisson.com
 * @time: 2013-11-6下午03:02:41
 */
public class BindCard  {

	private String staffCode;
	private String custCode;
	private String bindDate;
	private String bindOrderNo;
	/**
	 * 绑卡状态： S0A:生成 SOD:绑卡中 S0F:绑卡失败 S0C:绑卡成功
	 */
	private String bindState;
	private String bankCode;
	private String bankName;
	private String bankOpen;
	private String areaCode;
	private String bankAcct;
	/**
	 * 开户姓名
	 */
	private String transAccName;
	private String cerNo;
	private String openPhone;

	/**
	 *S0A: 有效 S0X: 无效
	 */
	private String stat;

	public String getStaffCode() {
		return staffCode;
	}

	public String getCustCode() {
		return custCode;
	}

	public String getBindDate() {
		return bindDate;
	}

	public String getBindOrderNo() {
		return bindOrderNo;
	}

	public String getBindState() {
		return bindState;
	}

	public String getBankCode() {
		return bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public String getBankOpen() {
		return bankOpen;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getBankAcct() {
		return bankAcct;
	}

	public String getTransAccName() {
		return transAccName;
	}

	public String getCerNo() {
		return cerNo;
	}

	public String getOpenPhone() {
		return openPhone;
	}

	public String getStat() {
		return stat;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public void setBindDate(String bindDate) {
		this.bindDate = bindDate;
	}

	public void setBindOrderNo(String bindOrderNo) {
		this.bindOrderNo = bindOrderNo;
	}

	public void setBindState(String bindState) {
		this.bindState = bindState;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setBankOpen(String bankOpen) {
		this.bankOpen = bankOpen;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct;
	}

	public void setTransAccName(String transAccName) {
		this.transAccName = transAccName;
	}

	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	public void setOpenPhone(String openPhone) {
		this.openPhone = openPhone;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
	
	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}


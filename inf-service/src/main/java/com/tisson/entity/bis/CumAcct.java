package com.tisson.entity.bis;

public class CumAcct {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.ACCT_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private Long acctId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.CUST_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private Long custId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.ACCT_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private String acctType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.ACCT_CODE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private String acctCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.BANK_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private Long bankId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.ACCT_NAME
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private String acctName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.CARD_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private String cardType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_CUM_ACCT.STAT
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	private String stat;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.ACCT_ID
	 * @return  the value of T_CUM_ACCT.ACCT_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public Long getAcctId() {
		return acctId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.ACCT_ID
	 * @param acctId  the value for T_CUM_ACCT.ACCT_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.CUST_ID
	 * @return  the value of T_CUM_ACCT.CUST_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public Long getCustId() {
		return custId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.CUST_ID
	 * @param custId  the value for T_CUM_ACCT.CUST_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.ACCT_TYPE
	 * @return  the value of T_CUM_ACCT.ACCT_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public String getAcctType() {
		return acctType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.ACCT_TYPE
	 * @param acctType  the value for T_CUM_ACCT.ACCT_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType == null ? null : acctType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.ACCT_CODE
	 * @return  the value of T_CUM_ACCT.ACCT_CODE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public String getAcctCode() {
		return acctCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.ACCT_CODE
	 * @param acctCode  the value for T_CUM_ACCT.ACCT_CODE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode == null ? null : acctCode.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.BANK_ID
	 * @return  the value of T_CUM_ACCT.BANK_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.BANK_ID
	 * @param bankId  the value for T_CUM_ACCT.BANK_ID
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.ACCT_NAME
	 * @return  the value of T_CUM_ACCT.ACCT_NAME
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public String getAcctName() {
		return acctName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.ACCT_NAME
	 * @param acctName  the value for T_CUM_ACCT.ACCT_NAME
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName == null ? null : acctName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.CARD_TYPE
	 * @return  the value of T_CUM_ACCT.CARD_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.CARD_TYPE
	 * @param cardType  the value for T_CUM_ACCT.CARD_TYPE
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType == null ? null : cardType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_CUM_ACCT.STAT
	 * @return  the value of T_CUM_ACCT.STAT
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public String getStat() {
		return stat;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_CUM_ACCT.STAT
	 * @param stat  the value for T_CUM_ACCT.STAT
	 * @mbggenerated  Mon Jan 27 13:59:45 CST 2014
	 */
	public void setStat(String stat) {
		this.stat = stat == null ? null : stat.trim();
	}
}
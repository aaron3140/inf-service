package com.tisson.webservice.rest.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


public abstract class CommonRequest {

	
	protected String svcCode;
	
	@NotEmpty
	protected String merId;

	protected String channelCode;

	protected String tmnNum;

	@NotEmpty
	protected String sign;

	@NotNull
	protected String cer;

	private String keep;
	
	private String custCode;

	private String staffCode;
	
	private String ip;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getCer() {
		return cer;
	}
	
	public String getChannelCode() {
		return channelCode;
	}


	public String getKeep() {
		return keep;
	}

	public String getMerId() {
		return merId;
	}

	public String getSign() {
		return sign;
	}

	@JsonIgnore
	public String getSvcCode() {
		return svcCode;
	}

	public String getTmnNum() {
		return tmnNum;
	}

	public void setCer(String cer) {
		this.cer = cer;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public void setKeep(String keep) {
		this.keep = keep;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setSvcCode(String svcCode) {
		this.svcCode = svcCode;
	}

	public void setTmnNum(String tmnNum) {
		this.tmnNum = tmnNum;
	}

//	public CommonReqAbs(String xmlStr, Object reserved) throws Exception {
//
//		// 获取签名信息
//		setVerifyParameters(doc);
//		
//		init(doc, reserved);
//		
//		//客户端接入采用MD5验证
//		if (!ChannelCode.AGENT_CHANELCODE.equals(channelCode)) {
//			//非客户端接入采用证书验证
//			// 验证商户签名
//			verify(xmlStr);
//			// 校验机构接入号和终端号绑定关系
//			verifyMeridTmnNum();
//		}
//	}
//
//	public void verifyMeridTmnNum() throws Exception {
//		BaseDao DAO = SpringContextHelper.getBaseDaoBean();
//		String sql = "select distinct t.link_num from t_pnm_server t where t.prtn_id = " +
//				"(select prtn.prtn_id from t_pnm_partner prtn where prtn.prtn_code = ?)";
//		String linkNum = null;
//		try {
//			linkNum = (String) DAO.queryForObject(sql, new Object[]{merId}, java.lang.String.class);
//		} catch (Exception e) {
//			throw new Exception("机构接入号的绑定终端号异常");
//		}
//		linkNum = Charset.trim(linkNum);
//		if( ! linkNum.equals(tmnNum)) {
//			throw new Exception("机构接入号和绑定终端号不匹配");
//		}
//		
//	}
//	
//	public void verifyByMD5(String xmlStr, String key) throws Exception {
//		xmlStr = xmlStr + "<KEY>" + key + "</KEY>";
//		String md5Str = MD5.MD5Encode(xmlStr);
//		System.out.println("xmlStr"+xmlStr+"  md5Str:"+md5Str+" sign:"+sign);
//		if (!md5Str.equals(sign)) {
//			throw new INFException(INFErrorDef.MD5_SIGN_VAREFY_FAIL, "SIGN验证无效");
//		}
//	}
//	public void verifyByMD5(String key) throws Exception {
//		if (cer!=null&&!cer.equals("")) {
//		cer = cer + "<KEY>" + key + "</KEY>";
//		String md5Str = MD5.MD5Encode(cer);
//		System.out.println("jsonStr"+cer+"  md5Str:"+md5Str+" sign:"+sign);
//		if (!md5Str.equals(sign)) {
//			throw new INFException(INFErrorDef.MD5_SIGN_VAREFY_FAIL, "SIGN验证无效");
//		}}
//	}
//	
//	public void verify(String xmlStr) throws Exception {
//		// 将cer从base64转换为对象
//		X509Certificate cerObj = NETCAPKI.getX509Certificate(cer);
//
//		// 获取证书指纹
//		String fingerprint = NETCAPKI.getX509CertificateInfo(cerObj, 1);
//
//		// 检查证书是否有效或证书是否存在对应的表TSymCer记录
//		if (!TSymCerDao.isCerStatValid(fingerprint)) {
//			throw new INFException(INFErrorDef.CER_INVALID, "证书无效");
//		}
//
//		// 检查商户状态是否正常
//		// MerchantCache.getSpInfo(merId, true);
//
//		// 检查证书是否属于该商户
//		if (!TSymCerDao.isCerOwnedByMer(fingerprint, merId)) {
//			throw new INFException(INFErrorDef.CER_NOTOWNED_BY_MER, "证书不匹配接入机构");
//		}
//
//		// 验证sign是否正确
//		// Element e = (Element) getNodeM(doc, "PayPlatRequestParameter");
//		// System.out.println("e:" + e.asXML());
//		// byte[] src = e.asXML().getBytes(CHARSET);
//		
//		String pay = xmlSubString(xmlStr);
//		/*
//		 <?xml version="1.0" encoding="UTF-8"?><Request><VerifyParameter><MERID>8604400000092200</MERID><CHANNELCODE>20</CHANNELCODE><TMNNUM>90000086</TMNNUM><SIGN/><CER/></VerifyParameter><PayPlatRequestParameter><CTRL-INFO  WEBSVRNAME="支付插件交易接口"  WEBSVRCODE="INF05002"  APPFROM="440000-APP001-001-127.0.0.1"  KEEP="90000086201303080743578154" /><PARAMETERS><STAFFCODE>khd12</STAFFCODE><PASSWORD>59903_1da84474695e4fdda12e11ae50b6319f</PASSWORD><VERIFYCODE>iqka</VERIFYCODE><REQUESTXML><![CDATA[<?xml version="1.0" encoding="UTF-8"?><Request><VerifyParameter><MERID>8604400000368400</MERID><CHANNELCODE>80</CHANNELCODE><TMNNUM>440106000141</TMNNUM><SIGN>0wuyf8bL9CvejPSVE/tyqHAVNH2bLnsTiFxKd1/aYJ2TTeH0+NI5o3R237j+l3bLELTei0YcEJDGk4++ettalPog9rNjCl3AcHPi/QzI37h1mm0oUsrrwDYDO8O8pyZEvbR1oq0znfMs4bRf3yc+kbC6cAAkg9b6bWdiqVWGkJ3qy1pjNg3jQzVXjeke42wstk8Z34N4i0Fk4fr3BPlCxQ1JxAD4O8/5PnwRghxMXEtHDz+PaD9gY1w2/P4tG8nEMIgoIGFiOXCqjfO1fLqlYZ+/O6sWC+SVuynvfk2qbnnR5mHW6TDhkgILkvhBBzqPudl25llLkl8D/JtGETeASQ==</SIGN><CER>MIIEdTCCA12gAwIBAgIQeOYX576OwdBzGHctPw6PSTANBgkqhkiG9w0BAQUFADBvMQswCQYDVQQGEwJDTjEkMCIGA1UEChMbTkVUQ0EgQ2VydGlmaWNhdGUgQXV0aG9yaXR5MRkwFwYDVQQLExBTZXJ2ZXIgQ2xhc3NBIENBMR8wHQYDVQQDExZORVRDQSBTZXJ2ZXIgQ2xhc3NBIENBMB4XDTEyMDMzMTE2MDAwMFoXDTE1MDQwMTE1NTk1OVowZzELMAkGA1UEBhMCQ04xEjAQBgNVBAgTCUd1YW5nZG9uZzErMCkGA1UECh4iZw1SoVZoi8FOZm1Li9UAMgAwADEAMgAwADQAMAAxAC0ANDEXMBUGA1UEAxMOdGVzdDIwMTIwNDAxLTQwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDYWtX4YTIYgmXAC6l2E//GQ1SjymJyPGNoDav+MJtUpXzcdub4yfKiLa6HWzzKUl9YyokwGtMUu020+8yy6BUNlmElcgrdqmZyej8fjlzjCw8BLwrxxKcbR9HZ8OEu1VSpy1w/KYpCEqT1gi4T3LP+Ug2SVbIXuFMsPSwywwVtl8mMcXQ3PqjD72IK+cOnWCimFk590uLlnyy6/z3vMa+XbjUG3haoCS8WLsJNufbs8HccTE6FYctCDNuSwhD7YOqKlMoMFnFnEN6wvZ57GS3NM1dd2sSqE4Ma8gE75w3VdOuoKsjnWfrGkbhkUmBiVuACt+/Aw3m8mngx33qyKjURAgMBAAGjggETMIIBDzAfBgNVHSMEGDAWgBS680oFJOb4JMjmV9p4jQxZ5ENkyjAdBgNVHQ4EFgQUKl+CBlrjAlL1DUAJs4M2QqAq2xMwVwYDVR0gBFAwTjBMBgorBgEEAYGSSAEKMD4wPAYIKwYBBQUHAgEWMGh0dHA6Ly93d3cuY25jYS5uZXQvY3Mva25vd2xlZGdlL3doaXRlcGFwZXIvY3BzLzAZBgNVHREEEjAQgg50ZXN0MjAxMjA0MDEtNDAMBgNVHRMBAf8EAjAAMA4GA1UdDwEB/wQEAwIEsDA7BgNVHR8ENDAyMDCgLqAshipodHRwOi8vY2xhc3NhY2ExLmNuY2EubmV0L2NybC9TZXJ2ZXJDQS5jcmwwDQYJKoZIhvcNAQEFBQADggEBAJ4QaFZjJ12Ayvyy0JyNZQ9eeNmCAUt4+aZY6IT/FDfm9HFB7jkVXxDY+eUTHc/cu4fDIidCNz+CTGlRoiVWJkDyQfmBpcXJE1OPJSHzMXXDgGfxstqZDkDJ+NAAX8TSunnd4/y/BjO/uoOxytVmetxWOxt4s6IhITzZS2y7Kntoghd+6IVK20VFS9mhqUL/YiRI4RU+TrjU8zm7+QSTpqfXfOwn1x8Eol+Pwu9+ZdMNLCA8MbbtmMKz/vbxMwBoFv9kedH0ui7d5AQiNGQHxp0IGYc1L48KpLE8bDeyjGNU+VjI/gmzxYM6bwOqLpoENnWm7M3NLhtIDj98Z4Wftrc=</CER></VerifyParameter><PayPlatRequestParameter>       <CTRL-INFO  WEBSVRNAME="test"  WEBSVRCODE="test"  APPFROM="1234"                KEEP="440106000141201303081051550351" /><PARAMETERS><AGENTCODE>khd12@163.com</AGENTCODE><AREACODE>510000</AREACODE><ACTIONCODE>1030</ACTIONCODE><TXNAMOUNT>2.5</TXNAMOUNT><PAYEECODE>gwwt02@test.com</PAYEECODE><GOODSCODE>ycorder</GOODSCODE><GOODSNAME>卷烟订购款</GOODSNAME><ORDERSEQ>ycoid0001</ORDERSEQ><TRANSSEQ></TRANSSEQ><TRADETIME>20130308105155</TRADETIME><MARK1>MARK1</MARK1><MARK2>MARK2</MARK2></PARAMETERS></PayPlatRequestParameter></Request>]]></REQUESTXML></PARAMETERS></PayPlatRequestParameter></Request>
//		 * */
//		if (!NETCAPKI.verifyPKCS1(pay.getBytes(CHARSET), NETCAPKI.base64Decode(sign), cerObj)) {
//			throw new INFException(INFErrorDef.CER_SIGN_VAREFY_FAIL, "签名验证失败");
//		}
//
//	}


}

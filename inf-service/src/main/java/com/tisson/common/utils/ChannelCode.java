package com.tisson.common.utils;

public enum ChannelCode {
	AGENT_CHANELCODE("20"), WS_CHANELCODE("80"), IPOS_CHANELCODE("60"), IVR_CHANELCODE(
			"40"), CHANELCODE_10("10");

	private String code;

	ChannelCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

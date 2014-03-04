package com.tisson.webservice.rest.domain;

import java.util.HashMap;
import java.util.Map;


public class CommonResponse {


	private String code;
	private String content;
	
	private Map<String, Object> data = new HashMap<String, Object>();
	

	public Map<String, Object> getData() {
		return data;
	}

	public String getCode() {
		return code;
	}

	public String getContent() {
		return content;
	}


	public void setCode(String code) {
		this.code = code;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

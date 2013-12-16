package com.tisson.service;

import com.tisson.webservice.rest.domain.CommonRequest;
import com.tisson.webservice.rest.domain.CommonResponse;

public class BaseService {

	/**
	 * 
	 * @param request 请求验证信息
	 * @param response 返回结果
	 * @return
	 */
	public boolean validation(CommonRequest request,CommonResponse response){
		
		
		return true;
	}
}

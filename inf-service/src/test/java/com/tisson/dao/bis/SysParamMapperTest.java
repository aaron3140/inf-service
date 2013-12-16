package com.tisson.dao.bis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.webservice.hessian.AbstractServiceTest;

public class SysParamMapperTest extends AbstractServiceTest  {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	SysParamMapper sysParamMapper;
	
	@Test
	public void testGetValByCode() {
		String paramCode = "TOKEN_VALIDTIME";
		String valByCode = sysParamMapper.getValByCode(paramCode);
		if(log.isInfoEnabled()){
			log.info(valByCode);
		}
	}

}

package com.tisson.dao.inf;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.dao.bis.SysParamMapper;
import com.tisson.webservice.hessian.AbstractServiceTest;

public class LoginLogMapperTest extends AbstractServiceTest  {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	LoginLogMapper loginLogMapper;
	
	@Autowired
	SysParamMapper sysParamMapper;
	
	
	@Test
	public void testGetMD5KeyByStaffCode() {
		String tokenValidTime = sysParamMapper.getValByCode("TOKEN_VALIDTIME");
		log.info(tokenValidTime);
		String staffCode = "zqdie";
		loginLogMapper.getMD5KeyByStaffCode(staffCode, StringUtils.isEmpty(tokenValidTime)?"10000":tokenValidTime);
	}

	@Test
	public void testUpdateRanduseTimeByStaffCode() {
		String  staffCode = "zqdie";
		loginLogMapper.updateRanduseTimeByStaffCode(staffCode);
	}

}

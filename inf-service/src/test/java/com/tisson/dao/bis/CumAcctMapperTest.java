package com.tisson.dao.bis;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.webservice.hessian.AbstractServiceTest;

public class CumAcctMapperTest extends AbstractServiceTest  {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CumAcctMapper cumAcctMapper;
	
	
	@Test
	public void testGetAcctCodeString() {
		String custCode = "";
		cumAcctMapper.getAcctCode(custCode);
	}

	@Test
	public void testGetBankCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParentAcctCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAcctCodeStringString() {
		fail("Not yet implemented");
	}

}

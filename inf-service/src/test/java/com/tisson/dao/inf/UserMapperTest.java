package com.tisson.dao.inf;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.entity.inf.User;
import com.tisson.webservice.hessian.AbstractServiceTest;

public class UserMapperTest extends AbstractServiceTest  {
	
	@Autowired
	UserMapper userMapper;

	@Test
	public void testGetUser() {
		String userId = "13250256893";
		User user = userMapper.getUser(userId);
//		if()
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindListByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLoginListByName() {
		fail("Not yet implemented");
	}

}

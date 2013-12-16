package com.tisson.service.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tisson.entity.inf.User;
import com.tisson.webservice.hessian.AbstractServiceTest;

public class UserServiceTest extends AbstractServiceTest  {

	@Autowired
	private UserService userService;
	
	@Test
	public void testGetUser() {
		String userId = "ming";
		userService.getUser(userId);
	}
	@Test
	public void testFindByName() {
		User user = userService.findByName("aaronMing");
		if(logger.isInfoEnabled())
		{
			logger.info("user info:"+user);
		}
	}
//
//	@Test
//	public void testFindListByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetUserMapper() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSetUserMapper() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindLoginListByName() {
//		fail("Not yet implemented");
//	}

}

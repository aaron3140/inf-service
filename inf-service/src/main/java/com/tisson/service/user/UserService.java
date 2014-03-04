package com.tisson.service.user;


import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisson.dao.inf.UserMapper;
import com.tisson.entity.inf.User;

@Service
public class UserService {
//	protected static final Log log = LogFactory.getLog(UserService.class);
	@Autowired
	private UserMapper userMapper;
	
	
	public User getUser(String userId){
		return userMapper.getUser(userId);
	}

	public User findByName(String name) {
//		log.debug("======================debug======"+name);
//		log.info("======================inf======"+name);
//		log.error("======================error======"+name);
		return userMapper.findByName(name);
//		return new User(new Date(),"bb","cc","dd");
	}
	public List<User> findListByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findListByName(name);
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	public List<User> findLoginListByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findLoginListByName(name);
	}

	
	
  
}

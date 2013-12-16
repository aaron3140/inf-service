package com.tisson.dao.inf;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.tisson.entity.inf.User;

public interface UserMapper {

	@Select("SELECT to_char(reg_date,'yyyy-mm-dd hh24:mi:ss') reg_date,cust_code,verify_code"
			+ "  FROM T_INF_CLNREGLOG WHERE cust_code = #{userId}")
	@Results({ @Result(property = "id", column = "reg_date"),
			@Result(property = "age", column = "cust_code"),
			@Result(property = "name", column = "verify_code") })
	User getUser(@Param("userId") String userId);

	public User findByName(String name);

	public List<User> findListByName(String name);

	public List<User> findLoginListByName(String name);
}

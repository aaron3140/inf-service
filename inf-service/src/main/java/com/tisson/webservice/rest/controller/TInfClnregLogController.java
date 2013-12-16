package com.tisson.webservice.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tisson.entity.inf.User;
import com.tisson.service.user.UserService;

@Controller
@RequestMapping("clnregLog")
public class TInfClnregLogController {
	@Resource
	UserService userService;
	List<User> resultlist = null;

	@RequestMapping("requestClnregLog")
	public String getClnerglog(HttpServletRequest request) {
		resultlist = new ArrayList<User>();
		String name = request.getParameter("CUST_CODE");
//		User user = userService.findByName(name);
//		if(user!=null){
//			resultlist.add(user);
//		}
		resultlist = userService.findListByName(name);
		request.setAttribute("resultlist", resultlist);
		return "responseClnregLog";
	}
	@RequestMapping("requestLogin")
	public String getClnergLogin(HttpServletRequest request){
		resultlist = new ArrayList<User>();
		String name = request.getParameter("CUST_CODE");
		resultlist = userService.findLoginListByName(name);
		request.setAttribute("resultlist", resultlist);
		return "responseClnregLog";
	}

	public List<User> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<User> resultlist) {
		this.resultlist = resultlist;
	}
}

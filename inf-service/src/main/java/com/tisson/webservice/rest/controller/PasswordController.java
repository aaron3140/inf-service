package com.tisson.webservice.rest.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tisson.service.password.PosEncryService;

@Controller
@RequestMapping("password")
public class PasswordController {
	@Resource
	PosEncryService posEncryService;
	String encryPassword = null;
	@RequestMapping("requestpassword")
	public String getEncryPassword(HttpServletRequest request){
		String password = request.getParameter("password");
		String ecardno = request.getParameter("ecardno");
		encryPassword = posEncryService.genPassword(password, ecardno);
		request.setAttribute("resultstring", encryPassword);
		return "responsepassword";
	}
	public String getEncryPassword() {
		return encryPassword;
	}
	public void setEncryPassword(String encryPassword) {
		this.encryPassword = encryPassword;
	}
}

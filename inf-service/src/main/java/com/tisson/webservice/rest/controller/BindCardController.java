package com.tisson.webservice.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tisson.entity.inf.BindCard;
import com.tisson.service.reg.BindCardService;

/**
 * 
 * 本类描述: 
 * 
 * @version: 企业帐户前置接口 v1.0
 * @author: 广州天讯瑞达通讯技术有限公司(zhuxiaojun)
 * @email: zhuxiaojun@tisson.com
 * @time: 2013-11-6下午03:25:36
 */
@Controller
@RequestMapping("bindCard")
public class BindCardController {
	@Resource
	BindCardService bindCardService;
	List<BindCard> resultlist = null;

	@RequestMapping("requestBindCard")
	public String getBindCardList(HttpServletRequest request) {
		resultlist = new ArrayList<BindCard>();
		String custcode = request.getParameter("CUST_CODE");
		resultlist = bindCardService.findListByCustCode(custcode);
		request.setAttribute("resultlist", resultlist);
		return "responseBindCard";
	}
}


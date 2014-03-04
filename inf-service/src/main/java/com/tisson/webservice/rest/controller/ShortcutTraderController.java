package com.tisson.webservice.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tisson.common.utils.exception.INFException;
import com.tisson.service.ShortcutTraderService;
import com.tisson.webservice.rest.BaseController;
import com.tisson.webservice.rest.domain.CommonResponse;
import com.tisson.webservice.rest.domain.ShortcutTraderRequert;
import com.tisson.webservice.rest.domain.ShortcutTrader;

/**
 * 
 * 快捷交易接口
 * 
 * @email: shuangming.yang@gmail.com
 * @time: 2013-12-11下午02:05:36
 */
@Controller
@RequestMapping(value = { "shortcutTrader" })
public class ShortcutTraderController extends BaseController {

	@Autowired
	private ShortcutTraderService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public CommonResponse getShortcatTrader(
			@RequestBody(required = false) @Valid ShortcutTraderRequert trader,
			BindingResult results, HttpServletRequest request) {
		CommonResponse response = new CommonResponse();
		response.setCode("000000");
		response.setContent("成功");
//		String ipAddr = getIpAddr(request);
//		response.setIp(ipAddr);

		// 字段及权限效验
		if (results.hasFieldErrors())
		{
			validateFiledErrors(results, response);
			return response;
		}

		try {
			  ShortcutTrader shortcatTrader = service.getShortcatTrader(trader);
			  response.getData().put("shortcatTrader", shortcatTrader);
		} catch (INFException e) {
			response.setCode(e.getErrCode());
			response.setContent(e.getErrReason());
		}

		return response;
	}

}

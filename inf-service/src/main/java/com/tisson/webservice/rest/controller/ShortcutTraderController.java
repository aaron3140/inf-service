package com.tisson.webservice.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tisson.common.utils.exception.INFErrorDef;
import com.tisson.common.utils.exception.INFException;
import com.tisson.service.shortcutTrader.ShortcutTraderService;
import com.tisson.webservice.rest.BaseController;
import com.tisson.webservice.rest.domain.ShortcutTraderRequert;
import com.tisson.webservice.rest.domain.ShortcutTraderResponse;

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

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ShortcutTraderService service;

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ShortcutTraderResponse getShortcatTrader(
			@RequestBody(required = false) @Valid ShortcutTraderRequert trader,
			BindingResult results, HttpServletRequest request) {
		ShortcutTraderResponse response = new ShortcutTraderResponse();
		String ipAddr = getIpAddr(request);
		response.setIp(ipAddr);

		// 字段及权限效验
		if (results.hasFieldErrors()) {
			StringBuilder sb = new StringBuilder();
			List<FieldError> errors = results.getFieldErrors();
			for (FieldError error : errors) {
				System.out.println(error.getField() + " - "
						+ error.getDefaultMessage());
				sb.append(error.getField()).append(":")
						.append(error.getDefaultMessage());
			}
			response.setCode(INFErrorDef.FIELD_INVALID);
			response.setContent(sb.toString());
		}

		try {
			response = service.getShortcatTrader(trader);
		} catch (INFException e) {
			response.setCode(e.getErrCode());
			response.setContent(e.getErrReason());
		}

		return response;
	}

}

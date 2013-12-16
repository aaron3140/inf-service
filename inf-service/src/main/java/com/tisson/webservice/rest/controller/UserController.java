package com.tisson.webservice.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tisson.webservice.rest.BaseController;
import com.tisson.webservice.rest.domain.UserDTO;

/**
 *    Shiro的配置文件中对/api/secure/**进行拦截，要求authBasic认证.
 *    
 * @version: rest test
 * @email: shuangming.yang@gmail.com
 * @time: 2013-12-6下午03:25:36
 */
@Controller
@RequestMapping(value ={"user", "/secure/user"})
public class UserController extends BaseController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 基于ContentNegotiationManager,根据URL的后缀渲染不同的格式
	 * eg. /api/user/1.xml 返回xml
	 * /api/user/1.json 返回json
	 */
	@RequestMapping(value="getUser")
	@ResponseBody
	public UserDTO getUser( @Valid   UserDTO user,  BindingResult results, HttpServletRequest request) {
		
		String ipAddr = getIpAddr(request);
		System.out.println(ipAddr);
		
		List<FieldError> errors = results.getFieldErrors();
	    for (FieldError error : errors ) {
	        System.out.println (error.getField() + " - " + error.getDefaultMessage());
	    }
		
		
		UserDTO dto = new UserDTO();
		dto.setLoginName("shuangming");
		dto.setEmail("shuangming.yang@gamil.com");
		return dto;
		
	}
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public UserDTO getUser(@Min(2) @PathVariable("id")  Long id) {
//		UserDTO dto = new UserDTO();
//		dto.setLoginName("shuangming");
//		dto.setEmail("shuangming.yang@gamil.com");
//		return dto;
//		
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserDTO createUser(@Valid @RequestBody(required=false) UserDTO user,BindingResult results) {
		
		List<FieldError> errors = results.getFieldErrors();
	    for (FieldError error : errors ) {
	        System.out.println (error.getField() + " - " + error.getDefaultMessage());
	    }
		
//		 results.
//		FieldError fieldError = results.getFieldError("loginName");
//		System.out.println(fieldError.toString());

	        return user;
	}
	

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<UserDTO> cancelUser(@PathVariable String id) {

//        OrderDeletedEvent orderDeleted = orderService.deleteOrder(new DeleteOrderEvent(UUID.fromString(id)));

//        if (!orderDeleted.isEntityFound()) {
//            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
//        }

//        Order order = Order.fromOrderDetails(orderDeleted.getDetails());

//        if (orderDeleted.isDeletionCompleted()) {
//            return new ResponseEntity<Order>(order, HttpStatus.OK);
//        }
//    	  return new ResponseEntity<Order>(order, HttpStatus.FORBIDDEN);
    	
    	UserDTO dto = new UserDTO();
        return new ResponseEntity<UserDTO>(dto, HttpStatus.FORBIDDEN);
    }
	
}


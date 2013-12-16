package com.tisson.service.reg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tisson.dao.inf.BindCardMapper;
import com.tisson.entity.inf.BindCard;

/**
 * 
 * 本类描述: 
 * 
 * @version: 企业帐户前置接口 v1.0
 * @author: 广州天讯瑞达通讯技术有限公司(zhuxiaojun)
 * @email: zhuxiaojun@tisson.com
 * @time: 2013-11-6下午03:23:48
 */
@Service
public class BindCardService {
	@Autowired
	private BindCardMapper bindCardMapper;
	public List<BindCard> findListByCustCode(String custcode) {
		return bindCardMapper.findListByCustCode(custcode);
	}

}


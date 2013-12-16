package com.tisson.dao.inf;

import java.util.List;

import com.tisson.entity.inf.BindCard;

/**
 * 
 * 本类描述: 
 * 
 * @version: 企业帐户前置接口 v1.0
 * @author: 广州天讯瑞达通讯技术有限公司(zhuxiaojun)
 * @email: zhuxiaojun@tisson.com
 * @time: 2013-11-6下午03:07:53
 */
public interface BindCardMapper {
	public List<BindCard> findListByCustCode(String custcode);
}


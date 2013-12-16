package com.tisson.dao.bis;

import org.apache.ibatis.annotations.Select;

public interface CumInfoMapper {
	
	@Select("select info.cust_id from t_cum_info info where info.cust_code=#{custCode}")
	String getCustIdByCode(String custCode);

}

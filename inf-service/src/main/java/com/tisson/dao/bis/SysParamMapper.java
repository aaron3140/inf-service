package com.tisson.dao.bis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface SysParamMapper {
	
	
	@Select("SELECT PARAM_VAL FROM T_SYM_SYSPARAM "
			+ "WHERE STAT = 'SOA' AND PARAM_CODE = #{paramCode}")
	  String getValByCode(@Param("paramCode") String paramCode);

}

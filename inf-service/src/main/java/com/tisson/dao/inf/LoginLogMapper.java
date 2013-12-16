package com.tisson.dao.inf;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginLogMapper {

	/**
	 * 获取加密令牌
	 * 
	 * @param staffCode
	 * @param tokenValidTime
	 * @return
	 */
	@Select("select DESRAND from T_INF_LOGINLOG where RANDUSETIME "
			+ "> trunc(sysdate - #{tokenValidTime} / 86400,'mi') and stat = 'SOA' and staffcode = #{staffCode} and rownum=1")
	String getMD5KeyByStaffCode(@Param("staffCode") String staffCode, @Param("tokenValidTime") String tokenValidTime);

	/**
	 * 更新加密令牌最后使用时间
	 * 
	 * @param staffCode
	 * @return
	 */
	@Update("update t_inf_loginlog set RANDUSETIME = sysdate where log_id = "
			+ "(select log_id from (select log_id from t_inf_loginlog where RANDUSETIME is not null and staffcode"
			+ " = #{staffCode} and stat = 'SOA' order by RANDUSETIME desc) where rownum = 1)")
	int updateRanduseTimeByStaffCode( String staffCode);

}

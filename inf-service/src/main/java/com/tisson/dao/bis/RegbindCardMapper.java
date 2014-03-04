package com.tisson.dao.bis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.tisson.entity.bis.RegbindCard;

public interface RegbindCardMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	int deleteByPrimaryKey(Long bindId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	int insert(RegbindCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	int insertSelective(RegbindCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	RegbindCard selectByPrimaryKey(Long bindId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	int updateByPrimaryKeySelective(RegbindCard record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_CUM_REGBINDCARD
	 * @mbggenerated  Tue Jan 21 20:43:13 CST 2014
	 */
	int updateByPrimaryKey(RegbindCard record);

	@Update("update t_cum_regbindcard set bind_state='S0F',stat='S0X',remark=#{remark} where  bind_orderno=#{orderNo} and stat='S0A'")
    public void updateBindStateToFail(@Param("orderNo")String orderNo,@Param("remark") String remark) ;
}
package com.tisson.dao.bis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CumCustomMapper {

	/**
	 * 查询交易
	 * @param custId
	 * @param customType
	 * @param thType
	 * @return
	 */
	@Select("select nvl(sum(TH),0) AS TH from T_CUM_CUSTOM where CUST_ID =#{custId} and CUSTOM_TYPE =#{customType} and TH_TYPE=#{thType}")
	String getSingleTrader(@Param("custId")String custId,@Param("customType") String customType,@Param("thType") String thType);

	/**
	 * 累计交易
	 * @param custId
	 * @return
	 */
	@Select("select nvl(sum(t.AMOUNT),0) as AMOUNT from T_INF_CONSUME t where  t.CUST_ID =#{custId} and t.SUM_STAT='S0A' and t.ORDER_STAT='S0C'")
	String getAmountCount(@Param("custId")String custId);


}

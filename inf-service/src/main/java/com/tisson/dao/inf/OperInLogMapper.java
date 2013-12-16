package com.tisson.dao.inf;

import org.apache.ibatis.annotations.Insert;

import com.tisson.entity.inf.OperInLog;
import com.tisson.webservice.rest.domain.CommonRequest;

public interface OperInLogMapper {

	@Insert("insert into T_INF_OPERINLOG (OPERIN_ID, KEEP, CONNECT_IP, TNMNUM, SVC_CODE, IN_DATE, IN_TYPE, OBJ_CODE, OBJ_VALUE,OBJ_CODE2 ,OBJ_VALUE2,STAT)")
	OperInLog insert(CommonRequest resquest);

	boolean selectTInfOperInLogByKeep(String keep);

	boolean updateAllow(long operInId, int i);

}

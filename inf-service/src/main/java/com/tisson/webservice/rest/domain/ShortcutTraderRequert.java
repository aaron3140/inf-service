package com.tisson.webservice.rest.domain;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ShortcutTraderRequert extends CommonRequest {

	private String staffCode;
	
	private String custCode;
	
	private List<UserDTO> users;

	@Length(min=200,max=1600 ,message="3132")
	public String getCustCode() {
		return custCode;
	}

	@NotBlank(message="staffcode 不能为空")
	public String getStaffCode() {
		return staffCode;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	
}

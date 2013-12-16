package com.tisson.webservice.rest.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement(name = "User")
public class UserDTO extends CommonRequest {

	private Long id;
	private String loginName;
	private String name;
	private String email;


	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	@NotNull(message = "user.username.null")
	@Size(min = 5, max = 10, message = "loginName.length.illegal")
	public String getLoginName() {
		return loginName;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String value) {
		email = value;
	}

	public void setId(Long value) {
		id = value;
	}

	public void setLoginName(String value) {
		loginName = value;
	}

	public void setName(String value) {
		name = value;
	}

	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

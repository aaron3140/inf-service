package com.tisson.entity.inf;

import java.io.Serializable;


public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 726640521399512510L;
	private String id = null;
	private String age = null;
	private String name = null;
	
	public String getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	
}
package com.gwg.user.entity;

import java.io.Serializable;

public class UserEntity implements Serializable{
	
	private String name;
	
	private String staffCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

}

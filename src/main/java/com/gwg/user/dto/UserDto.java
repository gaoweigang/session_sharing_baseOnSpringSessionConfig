package com.gwg.user.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	
	private String account;
	
	private String passwd;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


}

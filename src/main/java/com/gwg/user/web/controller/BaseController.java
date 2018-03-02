package com.gwg.user.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.gwg.user.dto.UserDto;

/**
 */
public class BaseController {
	/**
	 * 在这里为了简单起见，内存数据库
	 */
	protected static Map<String, UserDto> userDB = new HashMap<String, UserDto>(); 
	
	static {
		UserDto userOne = new UserDto();
		userOne.setAccount("13817191469");
		userOne.setPasswd("111111");
		UserDto userTwo = new UserDto();
		userTwo.setAccount("admin");
		userTwo.setPasswd("123456");
		userDB.put("13817191469", userOne);
		userDB.put("admin", userTwo);
	}
}

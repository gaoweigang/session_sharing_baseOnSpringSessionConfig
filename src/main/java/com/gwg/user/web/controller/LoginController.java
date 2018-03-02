package com.gwg.user.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gwg.user.dto.UserDto;

/**
 * 自Spring4.3开始推荐使用注解来解决一个类中多个方法
 */
@Controller
@RequestMapping("/api/user")
public class LoginController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	/**
	 * 登录/
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(UserDto user, HttpServletRequest request, HttpServletResponse response){
		logger.info("用户登录 start....,用户名：{}， 密码：{}", user.getAccount(), user.getPasswd());
		String account = user.getAccount();
		//从数据中查询用户信息
		UserDto userDto = userDB.get(account);
		//用户不存在
		if(userDto == null){
			logger.info("用户不存在，登录失败");
            return "login";
		}
		else if(userDto.getPasswd() != null && !userDto.getPasswd().equals(user.getPasswd())){//密码错误
			logger.info("用户密码不相符，登录失败");
            return "login";
			
		}
		logger.info("spring session:{}, sessionid:{}", request.getSession(), request.getSession().getId());
		request.getSession().setAttribute("gaoweiganggood", user);
		return "index";
	}
	

}

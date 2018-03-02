package com.gwg.user.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwg.user.common.Constant;
import com.gwg.user.common.Result;
import com.gwg.user.dto.UserDto;

/**
 * 自Spring4.3开始推荐使用注解来解决一个类中多个方法
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	/**
	 * 查询用户信息
	 */
	@RequestMapping(value="getList",method=RequestMethod.GET)
	public @ResponseBody Result getList(HttpServletRequest request){
		logger.info("getList 获取用户信息列表...sessionid:{}", request.getSession().getId());
		return new Result(true, "获取用户列表成功", userDB.values(), "200");
	}
	
	/**
	 * 添加用户信息
	 */
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public @ResponseBody Result addUser(@RequestBody UserDto userDto, HttpServletRequest request) {		
		logger.info("add 添加用户信息...sessionid:{}", request.getSession().getId());

        if (userDB.get(userDto.getAccount()) != null) {
            return new Result(false, "添加失败, 用户名" + userDto.getAccount() + "已存在", null, "500");
        }
        //为新增账号设置默认密码
        userDto.setPasswd("111111");
        userDB.put(userDto.getAccount(), userDto);
        return new Result(true, "添加成功", null, "200");
    }
	
	

}

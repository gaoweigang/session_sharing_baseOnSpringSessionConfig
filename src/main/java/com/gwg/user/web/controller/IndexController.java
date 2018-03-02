package com.gwg.user.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 自Spring4.3开始推荐使用注解来解决一个类中多个方法
 * 添加初始化登录，首页页面转发配置
 * 说明：这部分逻辑可以放到WebMvcConfigurerAdapter里面統一管理
 * 
 */
@Controller
public class IndexController {
	
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	/**
	 * 初始化登录页面
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login_view(){
		logger.info("访问登录页面....");
	    return "login";	
	}
	

}

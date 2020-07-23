package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;

@Controller
@RequestMapping(value="/user/api")
public class UserApiController {
	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/idcheck")
	public boolean idcheck(@RequestParam("userId") String id) {
		System.out.println("userController/idcheck(ajax)");
		System.out.println(id);
		
		boolean result = userService.checkId(id);
		return result;
	}
}

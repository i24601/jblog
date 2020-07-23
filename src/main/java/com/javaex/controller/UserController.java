package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		System.out.println("UserController:joinForm()");
		return "user/joinForm";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController:join()");
		
		//서비스를 통해 회원정보 저장
		userService.join(userVo);
		return "user/joinSuccess";
	}
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("UserController:loginForm");
	
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController:login");
		
		UserVo authUser = userService.login(userVo);
		
		if(authUser != null) { //로그인 성공일때
			System.out.println("로그인성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}else { //로그인 실패일때
			System.out.println("로그인실패");
			return "redirect:/user/loginForm?result=fail";
		}
		
	}
		
	
}

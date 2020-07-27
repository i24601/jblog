package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.service.UserService;
import com.javaex.service.CateService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CateService cateService;
	
	//회원가입 폼
	@RequestMapping(value="/joinForm")
	public String joinForm() {
		System.out.println("UserController:joinForm()");
		return "user/joinForm";
	}
	
	//회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController:join()");
		
		//서비스를 통해 회원정보 저장
		int result =userService.join(userVo);
		if(result==1) {
			blogService.newBlog(userVo);
			cateService.newCate(userVo);
			return "user/joinSuccess";
		} else {
			//회원가입 실패
			return "user/joinForm";
		}
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
			System.out.println("아이디: "+authUser.getId());
			System.out.println("userName: "+authUser.getUserName());
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}else { //로그인 실패일때
			System.out.println("로그인실패");
			return "redirect:/user/loginForm?result=fail";
		}
		
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("UserController:logout");
	
		//세션의 값을 삭제한다.
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

}

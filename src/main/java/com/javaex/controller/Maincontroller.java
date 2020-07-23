package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Maincontroller {
	
	@RequestMapping(value="/")
	public String main() {
		System.out.println("MainController:main()");
		return "main/index";
	}

}

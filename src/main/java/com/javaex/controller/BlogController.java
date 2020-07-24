package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping(value="/{id}")
	public String blog_main(@PathVariable("no") int no, Model model) {
		
		System.out.println("BlogController:blog_main()");
		return "blog/blog-main";
	}
	
}

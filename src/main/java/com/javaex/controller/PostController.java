package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserService;

@Controller
@RequestMapping(value = "/post")
public class PostController {

	@Autowired
	private UserService postService;
	
	// 포스트작성
	@RequestMapping(value = "/{id}/write")
	public String blog_write(@PathVariable("id") int id,
							 @RequestParam ("cateNo") int cateNo,
							 @RequestParam ("postContent") String postContent,
							 @RequestParam ("postTitle") String postTitle) {
		System.out.println("PostController:write");
		System.out.println("cateNo:"+cateNo);
		System.out.println(postContent);
		System.out.println(postTitle);
		return "redirect:/" + id + "/admin/writeForm";
	}
}
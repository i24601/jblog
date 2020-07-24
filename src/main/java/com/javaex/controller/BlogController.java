package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.cateService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private cateService cateService;
	
	//PathVariable은 param을 받는것이 아니다
	@RequestMapping(value="/{id}")
	public String blog_main(@PathVariable("id") int id,
							Model model) {
		System.out.println("BlogController:blog_main()");

		//블로그 카테고리 포스트
		BlogVo blogVo = blogService.getBlogData(id);
		List<CateVo> cateList = cateService.getCateData(id);
		System.out.println(blogVo.toString());
		System.out.println(cateList.toString());
		model.addAttribute("blogVo", blogVo);
		model.addAttribute("cateList", cateList);
		/* cateService.getCateData(id); */
		
		return "blog/blog-main";		
	}
	
	//admin-basic 페이지 이동
	@RequestMapping(value="/{id}/admin/basic")
	public String blog_admin(@PathVariable("id") int id,
							 Model model) {
		System.out.println("BlogController:blog_admin()");
		
		BlogVo blogVo = blogService.getBlogData(id);
		System.out.println(blogVo.toString());
		model.addAttribute("blogVo", blogVo);
		return "blog/admin/blog-admin-basic";		
	}
	
	//admin-category 페이지 이동
		@RequestMapping(value="/{id}/admin/category")
		public String blog_category(@PathVariable("id") int id,
								 Model model) {
			System.out.println("BlogController:blog_category()");
			List<CateVo> cateList = cateService.getCateData(id);
			model.addAttribute("cateList", cateList);
			
			
			
			
			//blogTitle 얻기위해
			BlogVo blogVo = blogService.getBlogData(id);
			System.out.println(blogVo.toString());
			model.addAttribute("blogVo", blogVo);
			
			
			
			
			
			
			System.out.println("cateList전달");
			System.out.println(cateList.toString());
			return "blog/admin/blog-admin-cate";		
	}
		
	//admin-writeForm 페이지 이동
	@RequestMapping(value="/{id}/admin/writeForm")
	public String blog_writeForm(@PathVariable("id") int id,
							 Model model) {
		System.out.println("BlogController:blog_writeForm()");
		List<CateVo> cateList = cateService.getCateData(id);
		model.addAttribute("cateList", cateList);
		
		
		
		
		BlogVo blogVo = blogService.getBlogData(id);
		System.out.println(blogVo.toString());
		model.addAttribute("blogVo", blogVo);
		
		
		
		
		return "blog/admin/blog-admin-write";		
	}
	
	//admin-basic 업데이트
	@RequestMapping(value="/{id}/admin/basic/update")
	public String blog_basicUpdate(@RequestParam("file") MultipartFile file, @ModelAttribute BlogVo blogVo) {
		System.out.println("BlogController:blog_update()");
		System.out.println("BlogController:blog_update()");
		System.out.println("BlogController:blog_update()");
		System.out.println("BlogController:blog_update()");

		System.out.println(blogVo.toString());
		blogService.update(file, blogVo);
		
		return "redirect:/"+blogVo.getId()+"/admin/basic";	
	}
	
	
	
	
}

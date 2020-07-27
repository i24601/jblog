package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CateService;
import com.javaex.service.PostService;
import com.javaex.vo.CateVo;

@Controller
@RequestMapping(value="/api/category")
public class CateApiController {
	
	@Autowired
	CateService cateService;
	@Autowired
	PostService postService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<CateVo> idcheck(@RequestParam("userId") int id) {
		System.out.println("ajax 카테고리 리스트");
		System.out.println(id);
		List<CateVo> cateList = cateService.getCateData(id);
		System.out.println("받은 카테고리"+cateList.toString());
		return cateList;
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public int add(@RequestBody CateVo cateVo) {
		System.out.println("ajax 카테고리 추가");
		
		return cateService.addCate(cateVo);
	}
}

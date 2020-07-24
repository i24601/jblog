package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	//회원가입 블로그
	public int newBlog(UserVo userVo) {
		System.out.println("BlogService:newBlog()");
		int result = blogDao.insert(userVo);
		System.out.println("insert결과 "+result);
		return result;
	}
	
	//블로그 데이터로딩 blogVo
	public BlogVo getBlogData(int id) {
		System.out.println("BlogService:getBlogData()");
		return blogDao.getBlogById(id);
	}
}

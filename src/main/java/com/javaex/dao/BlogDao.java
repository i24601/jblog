package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 블로그
	public int insert(UserVo userVo) {
		System.out.println("input "+userVo.toString());
		System.out.println("BlogDao:insert");
		return sqlSession.insert("blog.insert", userVo);
	}
	
	public BlogVo getBlogById(int id) {
		System.out.println("BlogDao:getBlogById");
		
		return sqlSession.selectOne("blog.selectOneById", id);
	}

}

package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//post 작성
	public int insert(PostVo postVo) {
		System.out.println("input "+postVo.toString());
		System.out.println("PostDao:insert");
		return sqlSession.insert("post.insert", postVo);
	}
	
	public PostVo selectByCateNo(int cateNo) {
		return sqlSession.selectOne("post.selectOne", cateNo);
	}
	
}

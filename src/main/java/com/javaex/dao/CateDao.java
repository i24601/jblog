package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class CateDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 카테고리
	public int insert(UserVo userVo) {
		System.out.println("input "+userVo.toString());
		System.out.println("CateDao:insert()");
		return sqlSession.insert("cate.insert", userVo);
	}
}

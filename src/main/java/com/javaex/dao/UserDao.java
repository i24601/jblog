package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int insert(UserVo userVo) {
		System.out.println("UserDao:insert");
		
		return sqlSession.insert("user.insert", userVo);
	}
	
	//회원정보 가져오기 ->세션저장용
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao:selectUser");
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	//아이디체크(ajax 용)
	public UserVo selectUser(String id) {
		System.out.println("userDao:selectUser(ajax)");
		System.out.println(id);
		UserVo userVo = sqlSession.selectOne("user.selectById", id);
		return userVo;
	}
}

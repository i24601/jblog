  
package com.javaex.dao;

import java.util.List;

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
	
	public List<PostVo> selectByCateNo(int cateNo) {
		return sqlSession.selectList("post.selectList", cateNo);
	}
	
	public PostVo selectByPostNo(int postNo) {
		return sqlSession.selectOne("post.selectOne", postNo);
	}
	
}
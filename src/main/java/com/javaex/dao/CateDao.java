package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;

@Repository
public class CateDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 카테고리
	public int insertNew(UserVo userVo) {
		System.out.println("input "+userVo.toString());
		System.out.println("CateDao:insertNew()");
		return sqlSession.insert("cate.insertNew", userVo);
	}
	
	//블로그 카테고리 로딩
	public List<CateVo> selectAllById(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("cNo", "");
		return sqlSession.selectList("cate.selectAll", map);
		
	}
	
	public List<CateVo> selectAllById(Map<String, Object> map){
		return sqlSession.selectList("cate.selectAll", map);
	}
	
	//카테고리 추가
	public int insertAdd(CateVo cateVo) {
		System.out.println("input "+cateVo.toString());
		System.out.println("CateDao:insertAdd()");
		return sqlSession.insert("cate.insertAdd", cateVo);
	}
	
	//카테고리 삭제
	public int delete(int cateNo) {
		System.out.println("input "+cateNo);
		System.out.println("CateDao:delete()");
		return sqlSession.insert("cate.delete", cateNo);
	}
}
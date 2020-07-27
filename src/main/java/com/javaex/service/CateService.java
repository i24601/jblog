package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CateDao;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;

@Service
public class CateService {
	

	@Autowired
	private CateDao cateDao;
	
	//회원가입 카테고리
	public int newCate(UserVo userVo) {
		System.out.println("CateService:newCate()");
		int result = cateDao.insert(userVo);
		System.out.println("insert결과 "+result);
		return result;
	}
	
	//블로그 카테고리 로딩
	public List<CateVo> getCateData(int id){
		System.out.println("CateService:getCateData()");
		
		return cateDao.selectAllById(id);
	}
	
	//카테고리 데이터로딩 list<cateVo>
}

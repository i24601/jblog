package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CateDao;
import com.javaex.vo.UserVo;

@Service
public class cateService {
	

	@Autowired
	private CateDao cateDao;
	
	//회원가입 카테고리
	public int newCate(UserVo userVo) {
		System.out.println("CateService:newCate()");
		int result = cateDao.insert(userVo);
		System.out.println("insert결과 "+result);
		return result;
	}
	
}

package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		int result = cateDao.insertNew(userVo);
		System.out.println("insert결과 "+result);
		return result;
	}
	
	//블로그 카테고리 로딩
	public List<CateVo> getCateData(String id){
		System.out.println("CateService:getCateData()");
		
		return cateDao.selectAllById(id);
	}
	
	//블로그 카테고리 추가
	public List<CateVo> addCate (CateVo cateVo){
		System.out.println("CateService:addCate()");
		cateDao.insertAdd(cateVo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", cateVo.getId());
		map.put("cNo", cateVo.getCateNo());
		return cateDao.selectAllById(map);
	}
	
	//블로그 카테고리 삭제
	public int deleteCate (int cateNo){
		System.out.println("CateService:deleteCate()");
		return cateDao.delete(cateNo);
	}
	
}
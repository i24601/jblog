package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.CateVo;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	//post 작성
	public int postWrite(PostVo postVo) {
		System.out.println("p service write");
		return postDao.insert(postVo);
	}
	
	public PostVo getPost(int postNo) {
		System.out.println("포스트 불러오기");
		return postDao.selectByPostNo(postNo);
	}
	
	
	public List<PostVo> getPList(int cateNo) {
		System.out.println("포스트 리스트 불러오기");
		return postDao.selectByCateNo(cateNo);
	}
	
	public Map<String, Object> getData(Map<String, Object> data) {
		System.out.println(data.toString());
		
		List<CateVo> cateList = (List<CateVo>)data.get("cateList");
		int cateNo = (int)data.get("cateNo");
		int postNo = (int)data.get("postNo");
		List<PostVo> postList = null;
		PostVo postVo = null;
		
		//메인
		if(cateList.size()!=0 && cateList!=null && cateNo==0 && postNo==0) {
			System.out.println("메인");
			cateNo = cateList.get(0).getCateNo();
			System.out.println(cateNo);
			postList = postDao.selectByCateNo(cateNo);
			System.out.println(postList.toString());
			postNo = postList.get(0).getPostNo();
			System.out.println(postNo);
			postVo = postDao.selectByPostNo(postNo);
			System.out.println(postVo.toString());
			System.out.println("메인끝");
		} 
		
		//post 선택시
		else if(cateList.size()!=0 && cateList!=null && cateNo!=0 && postNo!=0){
			System.out.println("포스트");
			postList = postDao.selectByCateNo(cateNo);
			postVo = postDao.selectByPostNo(postNo);
		}
		//카테고리 선택시
		else if(cateList.size()!=0 && cateList!=null && cateNo!=0 && postNo==0) {
			System.out.println("카테고리");
			postList = postDao.selectByCateNo(cateNo);
			postNo = postList.get(0).getPostNo();
			postVo = postDao.selectByPostNo(postNo);
		}
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("cateList", cateList);
		result.put("postVo", postVo);
		result.put("postList", postList);
		
		//else는 카테고리가 없을때 null 전달		
		return result;
	}
}
package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
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
	
	public PostVo getPost(int cateNo) {
		System.out.println("포스트 불러오기");
		System.out.println(cateNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateNo", cateNo);
		map.put("flag", "");
		
		return postDao.selectByCateNo(map).get(0);
	}
	
	
	public List<PostVo> getPost(int cateNo, String flag) {
		System.out.println("포스트 불러오기");
		System.out.println(cateNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cateNo", cateNo);
		map.put("flag", flag);
		
		return postDao.selectByCateNo(map);
	}
}
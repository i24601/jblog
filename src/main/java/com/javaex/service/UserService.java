package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//회원가입	
		public int join(UserVo userVo) {
			System.out.println("UserService:join");
			int result = userDao.insert(userVo);
			System.out.println(result);
			
			return result;
	}
	
	//로그인
	public UserVo login(UserVo userVo) {
		System.out.println("UserService:login");
	
		return userDao.selectUser(userVo);
	}
	
	//아이디 체크(ajax용)
	public boolean checkId(String id) {
		UserVo userVo = userDao.selectUser(id);
		boolean result = true;
		
		if(userVo == null) {
			result = true;
		}else {
			result = false;
		}
		
		return result;
	}
	
}

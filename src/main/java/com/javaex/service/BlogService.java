package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	//회원가입 블로그
	public int newBlog(UserVo userVo) {
		System.out.println("BlogService:newBlog()");
		int result = blogDao.insert(userVo);
		System.out.println("insert결과 "+result);
		return result;
	}
	
	//블로그 데이터로딩 blogVo
	public BlogVo getBlogData(int id) {
		System.out.println("BlogService:getBlogData()");
		return blogDao.getBlogById(id);
	}
	
	//블로그 업데이트
	public int update(MultipartFile file, BlogVo blogVo) {
		System.out.println("BlogService:update()");
	
		String saveDir = "C:\\javaStudy\\upload"; 
		
		//-저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + file.getOriginalFilename();;
		System.out.println("saveName:" + saveName);
		blogVo.setLogoFile(saveName);
		
		//-파일패스 생성(
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);		
		
		//파일업로드(복사)
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream( filePath );
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write( fileData );
			
			if (bout != null) {
				bout.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return blogDao.updateByBlogVo(blogVo);
	}
}

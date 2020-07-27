package com.javaex.vo;

public class CateVo {
	private int cateNo, cateOrder, postCnt;
	private String id, cateName, description, regDate;
	
	public CateVo() {
	}

	public CateVo(int cateNo, int cateOrder, int postCnt, String id, String cateName, String description,
			String regDate) {
		this.cateNo = cateNo;
		this.cateOrder = cateOrder;
		this.postCnt = postCnt;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public int getCateOrder() {
		return cateOrder;
	}

	public void setCateOrder(int cateOrder) {
		this.cateOrder = cateOrder;
	}

	public int getPostCnt() {
		return postCnt;
	}

	public void setPostCnt(int postCnt) {
		this.postCnt = postCnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CateVo [cateNo=" + cateNo + ", cateOrder=" + cateOrder + ", postCnt=" + postCnt + ", id=" + id
				+ ", cateName=" + cateName + ", description=" + description + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<a href="">정우성의 블로그입니다.</a>
	</h1>

	<c:choose>
		<c:when test="${authUser.id eq id}">
			<ul class="clearfix">
				<li><a class="btn_s" href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">내블로그 관리</a></li>
				<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</ul>
		</c:when>
		
		
		<c:otherwise>
			<ul class="clearfix">
				<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>
<!-- //header -->

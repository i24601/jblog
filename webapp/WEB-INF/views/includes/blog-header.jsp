<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<a href="">${blogVo.blogTitle}</a>
	</h1>

	<c:choose>

		<c:when test="${authUser.id ne null}">
			
			<ul class="clearfix">
				
				<%-- <c:if test="${authUser.id eq id}"> 로 해도 된다 @PathVariable로 받은 id가 넘어간다 왜그럴까 d.s가 자동으로 넘겨주는걸까?--%>
				<c:if test="${authUser.id eq blogVo.id}">
					<li><a class="btn_s" href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">내블로그 관리</a></li>
				</c:if>
			
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

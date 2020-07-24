<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header" class="clearfix">
	<h1>
		<c:if test="${blogVo ne null}">
			<a href="">${blogVo.blogTitle}</a>
		</c:if>
		
		<c:if test="${blogVo eq null}">
			<c:if test="${cateList ne null}">
				<a href="">${blogVo.blogTitle}</a>
			</c:if>
		</c:if>
		
	</h1>

	<c:choose>

		<c:when test="${authUser.id ne null}">
			
			<ul class="clearfix">
			
				<c:if test="${authUser.id eq id}">
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

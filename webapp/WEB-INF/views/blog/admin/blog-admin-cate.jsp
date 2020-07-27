<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>

<body>
	<div id="wrap">
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		<!-- 개인블로그 해더 -->


		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		
		      		
		      		
					
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
		      			
						<!-- 리스트 영역 -->
					</tbody>
					
					
					
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name" id="cateName"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc" id="description"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>

		<!-- 개인블로그 푸터 -->
		
	
	
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
	$(document).ready(function() {
	//전체 카테고리 리스트 불러오기
	fetchList();
	});
	
	//추가
	$("#btnAddCate").on("click", function() {
		
		var data = {id : "${authUser.id}",
					cateName : $("#cateName").val(),
					description : $("#description").val()};
		
		$.ajax({
			url : "${pageContext.request.contextPath }/api/category/add",
			type : "post",
			//헤더의 컨텐츠 타입
			contentType : "application/json",
			
			data : JSON.stringify(data),
			
			
			dataType : "json",
			success : function(cateList) {
				render(cateList[0], "down");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	
	
	function fetchList() {
		$.ajax({
			url : "${pageContext.request.contextPath }/api/category/list",
			type : "post",
			//헤더의 컨텐츠 타입
			//contentType : "application/json",
			data : {userId : "${authUser.id}"},
			
			
			
			
			dataType : "json",
			success : function(cateList) {
				/*성공시 처리해야될 코드 작성*/
				
				console.log("받은 카테고리"+cateList);
				
				for (var i = 0; i < cateList.length; i++) {
					render(cateList[i], "down");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	function render(CateVo, direction) {
		
		var str = "";
		str += '<tr id = "t-'+CateVo.cateNo+'">';
		str += '<td>' + CateVo.cateOrder + '</td>';
		str += '<td>' + CateVo.cateName + '</td>';
		str += '<td>' + CateVo.postCnt + '</td>';
		str += '<td>' + CateVo.description + '</td>';
		str += '<td class = "text-center"><img onclick="deleteCate('+CateVo.cateNo+')" class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>';
		str += '</tr>';
		
		console.log(str);
		if (direction == "down") {
			$("#cateList").append(str);
		} else if (direction == "up") {
			$("#cateList").prepend(str);
		}
	};
	
	function deleteCate(cNo) {
		$.ajax({
			url : "${pageContext.request.contextPath }/api/category/delete",
			type : "post",
			//헤더의 컨텐츠 타입
			//contentType : "application/json",
			data : {cateNo : cNo},
			
			
			
			
			dataType : "json",
			success : function(result) {
				/*성공시 처리해야될 코드 작성*/
				if(result==1){
					console.log(result+"건 처리")
					$("#t-"+cNo).remove();
				} else {
				}
				console.log(result+"건 처리");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}});
		};
	
	
</script>



</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">
	
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- 메인 해더 -->
	

		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id"></td>
		      			<td><button id="btnIdCheck" type="button" value="">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value=""></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value=""></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="y">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
	      		
			</form>
			
		</div>
		
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>		
		<!-- 메인 푸터  자리-->
		
	</div>

</body>

<script type="text/javascript">
	$("#btnIdCheck").on("click", function(){
		console.log("버튼클릭");
		var uId = $("#txtId").val();
		
		console.log(uId);
		
		var uerInfo ={
			userId: uId
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath }/user/api/idcheck",		
			
			type : "post",
			//contentType : "application/json",
			data : {userId: uId},
			
			dataType : "json",
			success : function(result){
				console.log(result);
				/*성공시 처리해야될 코드 작성*/
				if(result == true){
					$("#tdMsg").text("사용가능");
					$("#btnIdCheck").val("true");
				}else {
					$("#tdMsg").text("사용불가");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
		
	} );
	
	$("#btnJoin").on("click", function(){	
		var chk = $("#btnIdCheck").val();
		if(chk=='true') {
			return true;
		} else {
			$("#tdMsg").text("아이디 중복 확인해주세요");
			return false;
		}
	});
	
	$("#txtId").keypress(function(){
		var chk = $("#btnIdCheck").val();
		if(chk=='true'){
		$("#btnIdCheck").val("");
		$("#tdMsg").text("아이디가 변경되었습니다");
		}
	});
	
	
</script>

</html>
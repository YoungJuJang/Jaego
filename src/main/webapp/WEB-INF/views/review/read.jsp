<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resources/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 상세 정보</title>
<style type="text/css">
input:focus, textarea:focus,.form-control:focus , .btn:focus, .btn-dark:focus {  outline: none !important;box-shadow: none; }
.reviewContent{width:100%;height:200px; resize:none;}
#counter{border: none;}
.table{
	width: 600px;
}
.table>:not(caption)>*>*{
    border-bottom-width: 0px;
}
.table th{
	width: 20%
}
</style>
</head>
<body>
<%
	String memberId = null;
	if (session.getAttribute("memberId") != null) {//유저아이디 이름으로 세션이 존재하는 회원들은
	memberId = (String) session.getAttribute("memberId");//유저아이디에 해당 세션값을 넣어준다

}
%>
<div class="container mt-5 mb-5">
	<div class="row" style="float: none; margin:100 auto;">
	<div class="col-md-6" style="float: none; margin:0 auto;">
	
	<div class="title" style="text-align: center;"> <h1>클래스 리뷰</h1> </div> <br>
	<table border="1"  class="table"  >
		<!--  <tr>
			<th>리뷰번호</th>
			<td>${lecturereviewDto.reviewId}</td>
		</tr> -->
		<tr>
			<th>작성자</th>
			<td>${lecturereviewDto.reviewWriter}</td>
		</tr>
		<tr>
			<th>만족도</th>
			<!--<td>${lecturereviewDto.reviewScore}</td>-->
			<td>
			<c:choose>
			<c:when test = "${lecturereviewDto.reviewScore  eq 1 }">
			매우 불만족
			</c:when>
			<c:when test = "${lecturereviewDto.reviewScore eq 2 }">
			불만족
			</c:when>
			<c:when test = "${lecturereviewDto.reviewScore eq 3 }">
			보통
			</c:when>
			<c:when test = "${lecturereviewDto.reviewScore eq 4 }">
			만족
			</c:when>
			<c:otherwise>
			매우 만족
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${lecturereviewDto.reviewContent}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate pattern = "yyyy/MM/dd" value = "${lecturereviewDto.reviewRegdate}"/></td>
		</tr>
		
		
	</table>
	
	<div class="text-center">
	
	<c:if test="${memberLogin.memberId eq lecturereviewDto.memberId}">	
		<a href="<c:url value="/review/edit/${lecturereviewDto.reviewId}"/>?lectureId=${param.lectureId}"  class="btn btn-dark mr-3">수정</a>
		<a href="<c:url value="/review/delete/${lecturereviewDto.reviewId}"/>?lectureId=${param.lectureId}"  class="btn btn-dark mr-3">삭제</a>
	</c:if>	
	
		<a href="<c:url value="/review/list/" />?lectureId=${param.lectureId}"  class="btn btn-dark mr-3">리뷰 목록</a>
	</div>
	
	
		</div>
	</div>
</div>	

<script>
var lectureId='${param.lectureId}';
if(lectureId==""){
	alert("강의 번호가 필요합니다.");
	location.href="<c:url value="/" />";
}
</script>		
</body>
</html>
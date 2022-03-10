<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/resources/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰</title>
<style type="text/css">


.pagination li {
    margin-right: 30px;
}
table{
	margin-bottom: 20px !important;
}
.pagination {
    display: flex;
    padding-left: 0;
    list-style: none;
    flex-wrap: nowrap;
    justify-content: center;
}
.pagination .active a{
	color: red;
}
</style>
</head>
<body>

	<div class="title" style="text-align: center;"> <h1>클래스 리뷰</h1> </div> <br>
	<table class="table table-hover" border="1" style="width: 800px; margin:auto;">
		
		
			<thead>
				<tr>
					<td colspan="4">전체 리뷰 : ${totCount} 개</td>
				</tr>
			</thead>
			
		<tbody>	
		<tr style="text-align: center;">
			<th>NO</th>
			<th>별점</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach var="review" items="${reviewList}" varStatus="loop">
		<tr style="text-align: center;">
			
			<td style="width: 5%;">${review.rownum}</td>
			<td style="width: 10%; ">
			<c:choose>
			<c:when test = "${review.reviewScore eq 1 }">
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
			</c:when>
			<c:when test = "${review.reviewScore eq 2 }">
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
			</c:when>
			<c:when test = "${review.reviewScore eq 3 }">
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
			</c:when>
			<c:when test = "${review.reviewScore eq 4 }">
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starempty.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
			</c:when>
			<c:otherwise>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
				<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/starfilled.png" width="15" height="15"  onerror="this.src='./resources/icon/logo.jpg'"/>
			</c:otherwise>
			</c:choose>
			</td>
			
			<td style="width:35%;" id="content">
			<a href="<c:url value="/review/read/${review.reviewId}?lectureId=${pageMakers.lectureId}" />">
							${review.reviewContent}</a>
			<td style="width:15%;">
			<fmt:formatDate pattern = "yyyy/MM/dd" value = "${review.reviewRegdate}"/>
			</td>
			
		</tr>
		</c:forEach>
		</tbody>
		
		<tfoot>
				<tr>
					<td colspan="5" style="text-align: center; padding-top: 30px">${pagination}</td>
				</tr>
			</tfoot>
	
	</table>
			
	<br>
	<div class="text-center">		
		<a href ="<c:url value="/review/write"/>?lectureId=${pageMakers.lectureId}" class="btn btn-dark mr-3">리뷰 작성하기</a>
		<a href ="<c:url value="/lectureroom/list"/>?lectureId=${pageMakers.lectureId}" class="btn btn-dark mr-3">클래스룸 이동</a>
	<br><br><br>
	</div>
	
<script>
var lectureId='${param.lectureId}';
if(lectureId==""){
	alert("강의 번호가 필요합니다.");
	location.href="<c:url value="/" />";
}
</script>	
	 
</body>			
<%@ include file="/resources/layout/footer.jsp"%>
</html>
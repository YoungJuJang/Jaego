<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<div>
	<img alt="강의사진" src="${pageContext.request.contextPath}/resources/icon/registerMentor.png" width="1000px" height="800" class="mx-auto d-block "/>	
	<br><br><hr>	
	<div class="text-center">	
	<button class="btn btn-outline-primary btn-lg" onclick="location.href='${pageContext.request.contextPath}/MentorAdd'">멘토 신청하러 가기</button>
	</div>
		<br>
		<br>
	
</div>





<%@ include file="/resources/layout/footer.jsp"%>

</html>
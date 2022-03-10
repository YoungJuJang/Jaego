<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<section>
	<div class="container">
	    <h1>결제 성공</h1> <br><br>
	    <h4>클래스명 : ${viewInfo.viewLecture.lectureTitle}</h4>
	    <h4>클래스가격 : ${viewInfo.viewLecture.lecturePrice} 원</h4>
	    <h4>주문번호 : ${orderId}</h4>
	    <br><br><hr>
	    
	    <a href="<c:url value='/view/${viewInfo.viewLecture.lectureId}'/>" class="btn btn-outline-primary btn-lg mx-auto">클래스 정보 확인</a>
	    
	    <a href="<c:url value='/lectureroom/list'/>?lectureId=${viewInfo.viewLecture.lectureId}" class="btn btn-outline-primary btn-lg mx-auto">클래스룸으로 이동</a>
 	</div>
 	
</section>




<%@ include file="/resources/layout/footer.jsp"%>
</html>
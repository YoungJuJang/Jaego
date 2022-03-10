<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7653b71d493a39748afab35ffa5bbcc&libraries=services"></script>

<style>
 a { color:black !important; text-decoration:none !important } 
 a:hover { text-decoration:none !important }
</style>



<div class="container">
	<br><hr>
	<div class="mt-4">
		<h1 class="mx-1"><strong>나의 정보 확인</strong></h1>
		<br>
		 			
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>나의 이메일</h4></li>
 				<li class="list-group-item">${myProfile.memberEmail1} @ ${myProfile.memberEmail2}</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>비밀번호</h4></li>
 				<li class="list-group-item"><a href="#"> 비밀번호 변경</a></li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>휴대폰 번호</h4></li>
 				<li class="list-group-item">${myProfile.memberPhone1} - ${myProfile.memberPhone2} - ${myProfile.memberPhone3}</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>성별</h4></li>
 				<li class="list-group-item">${myProfile.memberGender}</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>나이대</h4></li>
 				<li class="list-group-item">			
	 				 <c:if test="${myProfile.memberAge == 1}">
	 				 20세 미만
	 				 </c:if>
	 				 <c:if test="${myProfile.memberAge == 2}">
	 				 20세 - 25세
	 				 </c:if>
	 				 <c:if test="${myProfile.memberAge == 3}">
	 				 25세 - 30세
	 				 </c:if>
	 				 <c:if test="${myProfile.memberAge == 4}">
	 				 30세 - 35세
	 				 </c:if>
	 				 <c:if test="${myProfile.memberAge == 5}">
	 				 35세 - 40세
	 				 </c:if>
	 				 <c:if test="${myProfile.memberAge == 6}">
	 				 40세 이상
	 				 </c:if>
 				</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>가입일</h4></li>
 				<li class="list-group-item"><fmt:formatDate value="${myProfile.memberRegdate}" pattern="yyyy년-MM월-dd일"/></li>
			</ul>
			<hr>
			
			<button class="btn btn-outline-primary mx-auto" onclick="location.href='${pageContext.request.contextPath}/ProfileEdit'">정보 수정</button>
	</div>	
	<br><br>
	<div class="mt-4">
	<h1><strong>내가 구매한 클래스 정보</strong></h1>
	<br><hr>
	<c:forEach var="lecture" items="${myOrderLecture}" varStatus="Loop">
			<c:forEach var="lectureImg" items="${myOrderLectureImg}" varStatus="Loop">
				<c:choose>
			 	   	<c:when test="${lecture.lectureId==lectureImg.lectureId}">
						<div class="card mx-auto" style="width:600px;">
						  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/lectureImg/${lectureImg.lectureImg}" alt="Card image">
						  <div class="card-body">
						    <h2 class="card-title"> 클래스 제목 : ${lecture.lectureTitle} </h2>
						    <p class="card-text"> 클래스 가격 :  ${lecture.lecturePrice} 원</p>
						    <button class="btn btn-outline-primary btn-lg mx-auto" onclick="location.href='${pageContext.request.contextPath}/lectureroom/list?lectureId=${lecture.lectureId}'">클래스룸으로 이동</button>
						  </div>								
						</div>
						<br><hr>
			 	   	</c:when>
			 	 </c:choose>
			</c:forEach>
	</c:forEach>
	</div>
</div>



<%@ include file="/resources/layout/footer.jsp"%>

</html>

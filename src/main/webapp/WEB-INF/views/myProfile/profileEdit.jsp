<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>


<style>
 a { color:black !important; text-decoration:none !important } 
 a:hover { text-decoration:none !important }
</style>



<div class="container">
	<br><hr>
	<div class="mt-4">
		<h1 class="mx-1"><strong>나의 정보 확인</strong></h1>
		<br>
		 <form action="/ProfileEdit" method="POST">		
			<ul class="list-inline list-group-flush mt-2">
				<li class="list-group-item"><h4>나의 이메일</h4></li>
 				<li class="list-inline-item my-2"><input class="form-control" style="width:200px"
 					value="${myProfile.memberEmail1}"></li> @ &nbsp;
 				
 				<li class="list-inline-item"><input class="form-control" style="width:200px"
 					value= "${myProfile.memberEmail2}"></li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>비밀번호</h4></li>
 				<li class="list-group-item"><a href="#"> 비밀번호 변경</a></li>
			</ul>
			<hr>
			<ul class="list-inline list-group-flush mt-2">
				<li class="list-group-item"><h4>휴대폰 번호</h4></li>
 				<li class="list-inline-item my-2"><input class="form-control" style="width:100px" value="${myProfile.memberPhone1}"> </li> 
 				<li class="list-inline-item"><input class="form-control" style="width:100px" value="${myProfile.memberPhone2}"> </li> 
 				<li class="list-inline-item"><input class="form-control" style="width:100px" value="${myProfile.memberPhone3}"> </li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>성별</h4></li>
 				<li class="list-group-item">
 					<select class="form-select" style="width:20%">
 						<option value="1" label="남자">
						<option value="2" label="여자">
					</select>

 				</li>
			</ul>
			
			
			
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>나이대</h4></li>
 				<li class="list-group-item">			
 					<select class="form-select" style="width:40%"> 
						<option value="1" label="20세 미만">
						<option value="2" label="20세 이상 25세 미만">
						<option value="3" label="25세 이상 30세 미만">
						<option value="4" label="30세 이상 35세 미만">
						<option value="5" label="35세 이상 40세 미만">
						<option value="6" label="40세 이상">
					</select>
 					<!-- 
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
	 				  -->
 				</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>가입일</h4></li>
 				<li class="list-group-item"><fmt:formatDate value="${myProfile.memberRegdate}" pattern="yyyy년-MM월-dd일"/></li>
			</ul>
			<hr>
			
			<input type="button" class="btn btn-outline-primary mx-3" value="수정하기" onclick="location.href='${pageContext.request.contextPath}/MyProfile'">
			
		</form>
	</div>	
	<br><br>
	
</div>



<%@ include file="/resources/layout/footer.jsp"%>

</html>

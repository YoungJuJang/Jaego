<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>

	<div class="container mt-3 5rem"><h1>로그인</h1><br>
		<form:form commandName="loginDto" method="POST">	<!-- 로그인시 무조건 메인화면으로??! 이전페이지로 돌아가는게 좋을듯 --> 
			
			<div class="login">
				<form:label path="memberEmail" class="form-label">이메일</form:label> <form:errors path="memberEmail"/>
				<form:input path="memberEmail" class="form-control" style="width:30%;"/><br>
				
				
				<!-- 이메일 <input name="memberEmail" id="memberEmail" type="text" placeholder="이메일">  -->
				<form:label path="memberPassword" class="form-label">비밀번호</form:label> <form:errors path="memberPassword"/> 
				<form:password path="memberPassword" class="form-control" style="width:30%;"/>
				
				<label style="color:#f00;"> ${msg2}</label> <br>
				<!-- 
				<c:if test="${msg2 == false}">
					<p style="color:#f00;"> 이메일 또는 비밀번호가 일치하지 않습니다. </p>
				</c:if>
				 -->

				
					<input type="submit" value="로그인" class="btn btn-outline-primary mt-2 mb-2" style="width:30%;">
				<div class="find">
					<input type="button" value="이메일/비밀번호 찾기" class="btn btn-primary" style="width:15%;" onclick="location.href='${pageContext.request.contextPath}/findPage'">
					<input type="button" value="회원가입" class="btn btn-primary" style="width:14.5%;" onclick="location.href='${pageContext.request.contextPath}/register'">
				</div>
			
			</div>
		
		</form:form>
	</div>
</body>



<%@ include file="/resources/layout/footer.jsp"%>		
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
<div class="container mt-5 mb-5">
	<div class="row" style="float: none; margin:100 auto;">
	<div class="col-md-6" style="float: none; margin:0 auto;">

		<form:form commandName="lectureroomDto" method="POST">
		<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/>
			
			
			<h4><label> 해당 글을 삭제하시겠습니까?</label></h4><br>
			
			<label>비밀번호</label>
			<input type="password" id="pwd" name="pwd" class="form-control" style="width:40%"/> ${msg}

			
			
		<div class="button mt-3 5rem">
			<input type="hidden" name="lectureId"  value="${lectureroomDto.lectureId}">
			<input type="submit" class="btn btn-dark mr-3" value="삭제">
			<a href="<c:url value="/lectureroom/read/${lectureroomId}" />"class="btn btn-dark mr-3" >취소</a>
		</div>
		
		</form:form>
	</div>
	</div>
</div>
	
</body>

<%@ include file="/resources/layout/footer.jsp"%>

</html>

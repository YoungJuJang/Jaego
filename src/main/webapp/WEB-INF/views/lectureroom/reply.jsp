<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
	<form:form commandName="reply" method="POST">
	<table border="1" style="width: 700px">
		<form:input type="hidden" path="lectureroomId" value="${lectureroomId}"/>
		<form:input type="hidden" path="lectureId" value="1"/>
		<form:input type="hidden" path="mentorId" value="1"/>
		<form:input path="lectureroomStatus" value="1"/>
		
		<tr>
			<th><form:label path="lectureroomTitle">제목</form:label></th>
			<td><form:input path="lectureroomTitle" />
			
		<tr>
			<th><form:label path="lectureroomReply">답글 내용</form:label></th>
			<td><form:input path="lectureroomReply" />
		</tr>
		<tr>
			<th><form:label path="memberId">작성자</form:label></th>
			<td><form:input path="memberId" />
			<form:errors path="memberId" /></td>
		</tr>
		<tr>
		<th><form:label path="lectureroomPassword">비밀번호</form:label></th>
			<td><form:input path="lectureroomPassword" />
			<form:errors path="lectureroomPassword" /></td>
		</tr>
		
		
		
	</table>
	<div>
		<input type="submit" value="등록">
		<a href="<c:url value="/lectureroom/read" />">이전 글</a>
	</div>
	
</form:form>	
</body>

<%@ include file="/resources/layout/footer.jsp"%>



</html>

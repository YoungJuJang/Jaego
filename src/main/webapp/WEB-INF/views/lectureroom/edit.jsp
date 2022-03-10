<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
<div class="container mt-5 mb-5">
	<div class="row" style="float: none; margin:100 auto;">
	<div class="col-md-6" style="float: none; margin:0 auto;">

	<form:form commandName="lectureroomDto" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/>
	
	<div class="title" style="text-align: center;"> <h1>클래스룸 </h1> </div> <br>
	<table border="1" style="width: 700px">
		<tr>
			<th><form:label path="lectureroomTitle">제목</form:label></th>
			<td><form:input path="lectureroomTitle" class="form-control"/>
			<form:errors path="lectureroomTitle" /> </td>
		</tr>
		<tr>
			<th><label class="writer">작성자</label></th>
			<td><label class="form-control-plaintext">&nbsp;${lectureroomDto.lectureroomWriter}</label></td>
		</tr>
		<tr>
			<th><form:label path="lectureroomFname">첨부파일</form:label></th>
			<td><input type=file name="file" class="form-control"/>
			<form:errors path="lectureroomFname" /> </td>
		</tr>
		<tr>
			<th><form:label path="lectureroomContent">내용</form:label></th>
			<td><form:textarea path="lectureroomContent" class="form-control" cols="20" rows="10"/>
			<form:errors path="lectureroomContent" /></td>
		</tr>
		<tr>
			<th><form:label path="lectureroomPassword">비밀번호</form:label></th>
			<td><input type="password" id="pwd" name="pwd" class="form-control"/> ${msg}
			<form:errors path="lectureroomPassword" /></td>
		</tr>

	</table>
	
		<div class="text-center button mt-3 5rem">
			<input type="hidden" name="lectureId"  value="${lectureroomDto.lectureId}">
			<input type="submit"  class="btn btn-dark mr-3" value="등록">
			<a href="<c:url value="/lectureroom/list"/>?lectureId=${lectureroomDto.lectureId}" class="btn btn-dark mr-3" >목록</a>
		</div><br><br><br>
	
	</form:form>
	</div>
	</div>
</div>
</body>

<%@ include file="/resources/layout/footer.jsp"%>


</html>

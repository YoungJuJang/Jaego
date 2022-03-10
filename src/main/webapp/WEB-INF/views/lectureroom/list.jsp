<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ include file="/resources/layout/header.jsp"%>


<body>
<div class="row" style="float: none; margin:100 auto;">
<div class="col-md-6" style="float: none; margin:0 auto;">
	<form:form commandName="lectureroomDto" method="POST">
		<!-- <h1>${pageMaker.lectureId}</h1>  -->
		
		<div class="title" style="text-align: center;"> <h1>클래스룸 Notice</h1> </div> <br>
		<table class="table table-hover" border="1" style="width: 800px">
		
			<thead>
				<tr>
					<th colspan="5">전체 게시글 : ${totCount} 개</th>
				</tr>
			</thead>
			<tbody>			
			<tr style="text-align: center;">
				<th>NO</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th>
				
			</tr>
			
			<c:forEach var="lectureroom" items="${lectureroomList}" varStatus="loop">
	
		
			<tr style="text-align: center;">
					<td style="text-align:center; width: 5%;">${lectureroom.rownum}</td>
					<td style="text-align:center; width: 30%;"><a href="<c:url value="/lectureroom/read/${lectureroom.lectureroomId}" />">
						${lectureroom.lectureroomTitle}</a></td>
				<c:if test="${lectureroom.mentorStatus eq '0'}">
					<td style="text-align:center; width: 15%;">${lectureroom.lectureroomWriter}</td>
				</c:if>
				<c:if test="${lectureroom.mentorStatus eq '1'}">
					<td style="text-align:center; width: 10%;"><label style="color:#149494;">[멘토]</label> ${lectureroom.lectureroomWriter}</td>
				</c:if>
					<td style="text-align:center; width: 20%;">
					<fmt:formatDate value="${lectureroom.lectureroomRegdate}" pattern="yyyy/MM/dd HH:mm"/></td>
					
					<td style="text-align:center; width: 10%;"><a href="${pageContext.request.contextPath}/displayFile2?fileName=${lectureroom.lectureroomFname}&orignalName=${lectureroom.lectureroomFname}">
						<c:if test="${not empty lectureroom.lectureroomFname}">
							<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/filefolder.png" width="20" height="20"  onerror="this.src='./resources/icon/logo.jpg'"/>
						</c:if>
					<c:if test="${empty lectureroom.lectureroomFname}">
						${lectureroom.lectureroomFname}
					</c:if> </a></td>	
			</tr>

			</c:forEach>
			</tbody>
			
		</table><br>
	<div class="text-center">
	<a href="<c:url value="/lectureroom/write"/>?lectureId=${pageMaker.lectureId}" class="btn btn-dark mr-3">글쓰기</a>
	<a href="<c:url value="/review/list/" />?lectureId=${pageMaker.lectureId}"  class="btn btn-dark mr-3">리뷰보기</a>
	</div><br><br><br>
	
</form:form>
</div>
</div>
</body>

<%@ include file="/resources/layout/footer.jsp"%>

</html>

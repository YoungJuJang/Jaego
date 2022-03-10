<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>


<nav class="navbar navbar-light bg-light">
	 <a class="nav-link text-center" style="margin-left:3rem; font-size:20px;" href="<c:url value="/list?category=1"/>"><img src="${pageContext.request.contextPath}/resources/icon/lang.png" style="display:block;" width="150px" height="100px" alt="logo">
	 외국어</a>
	<a class="nav-link text-center" style="margin-left:3rem; font-size:20px;" href="<c:url value="/list?category=2"/>"><img src="${pageContext.request.contextPath}/resources/icon/career2.png" style="display:block;" width="150px" height="100px" alt="logo">
		 커리어</a>	
	<a class="nav-link text-center" style="margin-left:3rem; font-size:20px;" href="<c:url value="/list?category=3"/>"><img src="${pageContext.request.contextPath}/resources/icon/design.png" style="display:block;" width="150px" height="100px" alt="logo">
		 디자인/영상</a>	
	<a class="nav-link text-center" style="margin-left:3rem; font-size:20px;" href="<c:url value="/list?category=4"/>"><img src="${pageContext.request.contextPath}/resources/icon/beauty.png" style="display:block;" width="150px" height="100px" alt="logo">
		 뷰티/헬스</a>	
	<a class="nav-link text-center" style="margin-left:3rem; font-size:20px;" href="<c:url value="/list?category=5"/>"><img src="${pageContext.request.contextPath}/resources/icon/life.png" style="display:block;" width="150px" height="100px" alt="logo">
		 라이프</a>
</nav>
<!-- 카드형 리스트 -->
<c:if test=	"${lectures.size()==0}"	> 
<div class="container">
<h1 class="text-center"><strong>게시물이 없습니다.</strong></h1>
</div>
</c:if>
<div class="row m-5" style="text-align:center;">
	<c:forEach var="lecture" items="${lectures}" varStatus="Loop">
			  <div class="col-sm-5 col-md-3 border border-2 mt-5 bg-success text-dark bg-opacity-10" style="margin-left:6.5%;">
			    <div class="thumbnail mx-auto">
			      <div class="caption">
			      	<h2 class="m-4" style="height:100px"><strong> [ ${lecture.lectureTitle} ] </strong></h2>
					<c:forEach var="lectureImg" items="${lecturesImg}" varStatus="Loop">
						<c:choose>
					 	   	<c:when test="${lecture.lectureId==lectureImg.lectureId}">
								  <img class="card-img-top" src="${pageContext.request.contextPath}/resources/lectureImg/${lectureImg.lectureImg}" alt="Card image"  width="300" height="350">
					 	   	</c:when>
					 	 </c:choose>
					</c:forEach>
			        <h4><strong>${lecture.lectureCategory}</strong></h4>
			        <p>${lecture.lecturePrice}원</p>
			       	<p><fmt:formatDate value="${lecture.lectureStart}" pattern="yyyy년-MM월-dd일"/>~<fmt:formatDate value="${lecture.lectureEnd}" pattern="yyyy년-MM월-dd일"/></p>
			   		
			        <p><a href="<c:url value='/view/${lecture.lectureId}'/>"class="btn btn-primary" role="button">보러가기</a></p>
			      </div>
			    </div>
			  </div>
    </c:forEach>
    
    <c:if test="${not empty pages}">
      <nav aria-label="Page navigation example">
	  <ul class="pagination nav justify-content-center mt-5">
	    <li class="page-item">
	      <a class="page-link" href="<c:url value="/main?page=${1}"/>" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach var = "i" begin="1" end="${pages}">
	    <li class="page-item"><a class="page-link" href="<c:url value="/main?page=${i}"/>">${i}</a></li>
	    </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="<c:url value="/main?page=${pages}"/>" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
	</c:if>
  
</div>   






<%@ include file="/resources/layout/footer.jsp"%>

</html>

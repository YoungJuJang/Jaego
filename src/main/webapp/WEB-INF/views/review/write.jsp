<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/resources/layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style type="text/css">
input:focus, textarea:focus,.form-control:focus , 
.btn:focus, .btn-dark:focus{  outline: none !important;box-shadow: none; 
}
#reviewContent{width:100%;height:200px; resize:none;}
#counter{border: none;}
.table>:not(caption)>*>*{
    border-bottom-width: 0px;
}
</style>
</head>
<body>

<div class="container mt-5 mb-5">
	<div class="row" style="float: none; margin:100 auto;">
	<div class="col-md-6" style="float: none; margin:0 auto;">
	
	<form:form commandName="lecturereviewDto" method="POST">
	<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/>
	<div class="title" style="text-align: center;"> <h1>클래스 리뷰</h1> </div> <br>
	<table border="1" class="table" >
		
		
		<tr>
			<th><label class="title">강의명</label></th>
			<td><label class="form-control" class="form-control"> ${lecturereviewDto.title}</label></td>
			<!-- 
			<input name="title"  id="title"  class="form-control"	
			 oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  
				value="${lecturereviewDto.title}" readonly/>
			-->
			
		</tr>
	
		<tr>
			<th><form:label path="reviewWriter">작성자</form:label></th>
			<td><form:input path="reviewWriter" id="reviewWriter" class="form-control" placeholder="익명의 이름을 입력해주세요"/>
			<form:errors path="reviewWriter" /></td>
		</tr>
		<tr>
			<th><form:label path="reviewScore">만족도</form:label></th>
			<td>
			<form:radiobutton path="reviewScore" value="1" label="매우 불만족"/>
			<form:radiobutton path="reviewScore" value="2" label="불만족"/>
			<form:radiobutton path="reviewScore" value="3" label="보통"/><br>
			<form:radiobutton path="reviewScore" value="4" label="만족"/>
			<form:radiobutton path="reviewScore" value="5" label="매우 만족"/>
			<form:errors path="reviewScore" />
			</td>
		</tr>
		
		<tr>
			<th><form:label path="reviewContent">리뷰내용</form:label></th>
			<td>
			
			<form:textarea class="form-control" path="reviewContent"   />
      		<p><br>
      		<span class="txsub mt-3">남은글자수 :
      			<input type="text" readonly  value="500" name="counter" id="counter">
      		</span>
      		</p>
			
			
			<form:errors path="reviewContent" /></td>
		</tr>
		
		
	</table><br>
	<div class="text-center">
		<input type="button" class="btn btn-dark mr-3"  value="등록" onclick="formCheck()">
		<a href="<c:url value="/review/list/" />?lectureId=${lecturereviewDto.lectureId}"  class="btn btn-dark mr-3" >취소</a>
	</div><br><br><br>
	
	
</form:form>
	</div>
	</div>	
</div>

<script type="text/javascript">
 
function formCheck(){
	
	const reviewScore=$("input[name=reviewScore]:checked").val();
	const reviewContent=$("#reviewContent").val();
	console.log(reviewScore, reviewContent);
	
	var write = document.reviewContent;
	
	
	if(reviewScore==undefined){
		alert("만족도를 선택해 주세요.");
		return;
	}
	

	if(reviewContent ==""){
		alert("리뷰내용을 입력해 주세요.");
		$("#reviewContent").focus();
		return;
	}
	
	$("#lecturereviewDto").submit();
	
	
}

$(function(){
	$('#reviewContent').keyup(function (e){
	    var content = $(this).val();       
	    $('#counter').val(500-content.length);
	    if(content.length > 500) {
	    	$(this).val($(this).val().substring(0, 500));
	    }
	});
})

</script>

<script>
var lectureId='${param.lectureId}';
if(lectureId==""){
	alert("강의 번호가 필요합니다.");
	location.href="<c:url value="/" />";
}
</script>		

</body>
<%@ include file="/resources/layout/footer.jsp"%>
</html>
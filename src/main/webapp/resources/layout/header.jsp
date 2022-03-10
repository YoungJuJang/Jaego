<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
 <script type="text/javascript" charset="utf-8">
	sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
	
	var loopSearch=true;
	
	function keywordSearch(){
		if(loopSearch==false)
			return;
	 var value=document.getElementById("search").value;
	 	if(value==""){
			hide('suggest');
	 	}
		$.ajax({
			type : "get",
			async : true, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/Jaego/keywordSearch.do",
			data : {keyword:value},
			success : function(data, textStatus) {
				if(data.length != 0){
			    var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax	
	}
	
	function displayResult(jsonInfo){

		var count = jsonInfo.keyword.length;
		if(count > 0) {
		    var html = '';
		    for(var i in jsonInfo.keyword){
			   html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
		    }
		    var listView = document.getElementById("suggestList");
		    listView.innerHTML = html;
		
		    show('suggest');
		}else{
		    hide('suggest');
		}
	
	}
	
	
	function select(selectedKeyword) {
		document.getElementById("search").value=selectedKeyword;
		 loopSearch = false;
		 hide('suggest');
	}
		
	function show(elementId) {
		 var element = document.getElementById(elementId);
		 if(element) {
		  element.style.display = 'block';
		 }
		}
	
	function hide(elementId){
	   var element = document.getElementById(elementId);
	   if(element){
		  element.style.display = 'none';
	   }
	} 
	
</script>
<!--  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4b7596e2ffe60ae94169db689dd804cf&libraries=services"></script>
-->
<title>Jaego</title>
</head>
<div class="mx-5 border">
	<header>
		<nav class="navbar navbar-expand-lg text-dark navbar-dark ">
			  <a class="navbar-brand"  class="ml-3" href="<c:url value="/main"/>">    	
			  	<img src="${pageContext.request.contextPath}/resources/icon/logo.jpg" width="200" height="170" alt="logo">
			  </a>
			    <div class="navbar-nav  mx-auto mt-5">
				    <form class="d-flex"  action="<c:url value="/search"/>" method="get">
				    <input class="form-control me-4 col-lg-10" type="search" id="search" name ="search" placeholder="Search" aria-label="Search" onKeyUp="keywordSearch()">
	
				    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				   </form>
				    
			     </div>
			 
		 	   <nav class="navbar navbar-dark ml-4 ">
		 	   <c:choose>
		 	   	<c:when test="${empty sessionScope.memberLogin}">
			 	   	   	<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/register'/>">register</a>
			 		  	<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/login'/>">login</a>
			 	</c:when>
			 	<c:when test="${memberLogin.memberMentorStatus eq 1}">
			 	   	   	<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/MyProfile'/>">나의 프로필 </a>		 
			 			<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/MyMentorLecture'/>">나의 멘토/클래스 </a>		 
			 			<nav class="nav-item nav-link mx-2 text-dark border">반갑습니다. ${memberLogin.memberName}님</nav>	
			 			<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/logout'/>">로그아웃! </a>
			 	</c:when>
			 	<c:otherwise>
			 			<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/MyProfile'/>">나의 프로필 </a>		 
			 			<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/MyMentorLecture'/>">멘토/클래스 신청서 </a>		 
			 			<nav class="nav-item nav-link mx-2 text-dark border">반갑습니다. ${memberLogin.memberName}님</nav>	
			 			<a class="nav-item nav-link mx-2 text-dark border" href="<c:url value='/logout'/>">로그아웃! </a>		 
			 	</c:otherwise>
			   </c:choose>
			   </nav>			
		</nav>
		  <ul id="suggest" class="list-group text-center">
       	 	<li id="suggestList" class="list-group-item">  </li> 
       	  </ul>
		  
	</header>
<body>

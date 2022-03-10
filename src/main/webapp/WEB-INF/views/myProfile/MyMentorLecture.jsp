<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7653b71d493a39748afab35ffa5bbcc&libraries=services"></script>

<style>
 a { color:black !important; text-decoration:none !important } 
 a:hover { text-decoration:none !important }
</style>



<div class="container">
	<div class="border border-primary p-4">
		<h1><strong>멘토 신청서</strong></h1>
		<hr>
		<h4>멘토 이미지</h4>
		 <img alt="멘토사진" src="${pageContext.request.contextPath}/resources/mentorImg/${myMentor.mentorImg}" width="200" height="200" class="mx-auto rounded-circle d-block " onerror="this.src='./resources/icon/logo.jpg'"/>			
		<br><hr>
		<h4>멘토 소개 내용</h4>
		<div class="card">
 			<div class="card-body">
		${myMentor.mentorContent}
			</div>
		</div>
		<br><hr>
		<h4>멘토 경력</h4>
		${myMentor.mentorCareer1}
		<br>
		${myMentor.mentorCareer2}
		<br>
		${myMentor.mentorCareer3}
		<br>
		${myMentor.mentorCareer4}
		<br>
		${myMentor.mentorCareer5}
		<br><hr>
		<h4>멘토 소셜미디어</h4>
		<a href="${myMentor.mentorLink1}">${myMentor.mentorLink1}</a>
		<br>
		<a href="${myMentor.mentorLink2}">${myMentor.mentorLink2}</a>
		<br>
		<a href="${myMentor.mentorLink3}">${myMentor.mentorLink3}</a>
		<br><hr>
		<h4>멘토 은행 계좌</h4>
		${myMentor.mentorBank} / ${myMentor.mentorAccount}
	</div>
	<br><br>
	<hr>
 <c:choose>
	<c:when test="${myMentor.mentorStatus==1 && not empty myLecture}"> 
	<div class="border border-primary p-4"> <c:if test="${myLecture.lectureStatus==0}">관리자가 클래스를 확인중입니다.(승인 이후 조회됩니다.)</c:if>
		<h1><strong>클래스 신청서</strong></h1>
		<hr>
		<h4>클래스 이미지</h4>
		<br>
		<c:forEach var="lectureImg" items="${myLectureImg}" varStatus="Loop">	
			<img alt="강의사진" src="${pageContext.request.contextPath}/resources/lectureImg/${lectureImg.lectureImg}" width="800" height="500" class="mx-auto  d-block "/>			
			<br><hr>
		</c:forEach>
		<h4>클래스 제목 및 내용</h4>
		<br>
		<div class="card">
		  <h3 class="card-header">${myLecture.lectureTitle}</h3>
		 <span style="text-align:right"> <strong>시간 당 / ${myLecture.lecturePrice}원</strong></span>
		  <div class="card-body">
		  	    <p class="card-text">클래스 기간 :  ${start} ~ ${end}</p>
		  	    <hr>
		  		<p class="card-text">클래스 카테고리 :  ${myLecture.lectureCategory}</p>
		  		<hr>
		  		<p class="card-text">클래스 수용인원  :  ${myLecture.lectureMaxcount}</p>
		  		<hr>
		  	
		      <h4 class="card-title">${myLecture.lectureContent}</h4>
		  
		  </div>
		</div>
		<hr>
		<h4>강의 장소</h4>
		<br>
		<div id="map" style="width:100%; height:350px;"></div>
		
		
		<c:if test="${myLecture.lectureStatus==1}">
			<div class="mt-4">
			<h1><strong>진행중인 클래스</strong></h1>
			<br><hr>
			<button class="btn btn-outline-primary btn-lg mx-auto" onclick="location.href='${pageContext.request.contextPath}/lectureroom/list?lectureId=${myLecture.lectureId}'">클래스룸으로 이동</button>
			
			</div>
		</c:if>
	
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${myLecture.lectureRoadAddress}' , function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px; text-align:center; padding:6px 0;">강의 장소</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
	
	</div>
	</c:when>
		<c:when test="${myMentor.mentorStatus==1 && empty myLecture}"> 
		<br>
		<div class="text-center">
		<h1><strong>클래스 신청하러 가기</strong></h1>
		<br>
		<a href="<c:url value='/LectureAdd'/>"><img alt="클래스신청" src="${pageContext.request.contextPath}/resources/icon/classAdd.png" width="1000" height="400" class="mx-auto  d-block "></a>
		</div>
	</c:when>
	<c:otherwise>
	<div class="text-center">
		<h3>관리자에게 승인을 받아야 클래스를 만들 수 있습니다.</h3> 
		 <h2>승인 중</h2>
		 <div class="spinner-border text-primary mx-2"></div>
	</div>
	</c:otherwise>
</c:choose>

<br><br>

		
		
		

	
</div>



<%@ include file="/resources/layout/footer.jsp"%>

</html>

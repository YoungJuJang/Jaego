<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a7653b71d493a39748afab35ffa5bbcc&libraries=services"></script>


<div class="container">
	<div class="border border-primary p-4">
			 <img alt="멘토사진" src="${pageContext.request.contextPath}/resources/mentorImg/${viewInfo.viewMentor.mentorImg}" width="300" height="300" class="mx-auto rounded-circle d-block mb-5" onerror="this.src='./resources/icon/logo.jpg'"/>			
			<h2 class="mb-3"><img alt="멘토소개" src="${pageContext.request.contextPath}/resources/icon/introduce.png" width="50" height="50"  onerror="this.src='./resources/icon/logo.jpg'"/> ${viewInfo.viewMentor.mentorContent}</h2>
			<h2><img alt="멘토경력" src="${pageContext.request.contextPath}/resources/icon/career.png" width="50" height="50"  onerror="this.src='./resources/icon/logo.jpg'" class="mr-5"/>${viewInfo.viewMentor.mentorCareer1}
			 <c:if test="${viewInfo.viewMentor.mentorCareer2!=null}">		
			,${viewInfo.viewMentor.mentorCareer2}
			</c:if>
			<c:if test="${viewInfo.viewMentor.mentorCareer3!=null}">		
			,${viewInfo.viewMentor.mentorCareer3}
			</c:if>
			<c:if test="${viewInfo.viewMentor.mentorCareer4!=null}">		
			,${viewInfo.viewMentor.mentorCareer4}
			</c:if>
			<c:if test="${viewInfo.viewMentor.mentorCareer5!=null}">		
			,${viewInfo.viewMentor.mentorCareer5}
			</c:if>
			</h2>
	
	</div>
</div>
<br><hr><br>
<div class="container">
	<div class="border border-primary p-4">
	
			<p class="fs-1 text-center"><strong>${viewInfo.viewLecture.lectureTitle}</strong></p>
			<h2 class="fst-italic"><strong>The number of students</strong></h2>
			<h1>총  ${viewInfo.viewLecture.lectureMaxcount}  명 중 			
			<c:forEach var="member" items="${members}" varStatus="Loop">
				 <c:if test="${member.memberAge == 1}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   				<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male10.png" width="200" height="100"  onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 				<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female10.png"width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>
				 <c:if test="${member.memberAge == 2}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   					<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male20.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 					<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female20.png" width="200" height="100"  onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>	
				 <c:if test="${member.memberAge == 3}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   					<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male25.png" width="200" height="100"  onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 					<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female25.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>			
				<c:if test="${member.memberAge == 4}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   					<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male30.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 					<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female30.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>	
				 <c:if test="${member.memberAge == 5}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   					<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male35.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 					<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female35.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>	
				 <c:if test="${member.memberAge == 6}">
				 	   	<c:choose>
		 	   				<c:when test="${member.memberGender=='남'}">
		 	   					<img alt="남자" src="${pageContext.request.contextPath}/resources/icon/male40.png" width="200" height="100"  onerror="this.src='./resources/icon/logo.jpg'"/>
			 				</c:when>
			 			<c:otherwise>
			 					<img alt="여자" src="${pageContext.request.contextPath}/resources/icon/female40.png" width="200" height="100" onerror="this.src='./resources/icon/logo.jpg'"/>
					 	</c:otherwise>				
					    </c:choose>
				 </c:if>	
			</c:forEach> 참여하고 계십니다!!</h1>

			
			<h2 class="fst-italic"><strong>Lecture Curriculum</strong></h2>
			<img alt="강의 커리큘럼" src="${pageContext.request.contextPath}/resources/lectureImg/${viewInfo.viewLectureImg[1].lectureImg}" width="100%" height="600" class="mx-auto d-block " onerror="this.src='./resources/icon/logo.jpg'"/>	
			<h2 class="fst-italic mt-5"><strong>Lecture Map</strong></h2>			 		
			<div id="map" style="width:100%; height:350px;"></div>
		
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
			geocoder.addressSearch('${viewInfo.viewLecture.lectureRoadAddress}' , function(result, status) {
			
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
			<h2 class="fst-italic mt-5"><strong>Lecture Price & Lecture Date</strong></h2>
				<div class="card text-center">
					  <div class="card-body">
					    <h1 class="card-title">${viewInfo.viewLecture.lecturePrice} 원</h1>
					  </div>
					  <div class="card-footer text-muted">
					    <h2><fmt:formatDate value="${viewInfo.viewLecture.lectureStart}" pattern="yyyy년-MM월-dd일"/> 부터 ~ <fmt:formatDate value="${viewInfo.viewLecture.lectureEnd}" pattern="yyyy년-MM월-dd일"/>까지</h2> 
					  </div>
				</div>
	
	</div>
	<hr><br>
	 
		<div class="form-check text-center">
			<c:choose>
		 	   	<c:when test="${memberSize >= viewInfo.viewLecture.lectureMaxcount}">
					<h1>마감 되었습니다!!</h1>
			 	</c:when>
			 	<c:otherwise>
				 <label class="form-check-label mx-4" style=" font-size: 30px;" for="flexRadioDefault1"><input class="form-check-input mx-auto" type="radio" name="method" value="카드" checked/>신용카드</label>
				 <label  class="form-check-label" style=" font-size: 30px;" for="flexRadioDefault1"><input class="form-check-input mx-auto" type="radio" name="method" value="가상계좌"/> 가상계좌</label><br><br>
				 <button id="payment-button" class="btn btn-outline-primary m-3 btn-lg">결제하기</button>
			 	</c:otherwise>				
			 </c:choose>
		</div>
	<hr><br><br>
</div>





<%@ include file="/resources/layout/footer.jsp"%>
  <script src="https://js.tosspayments.com/v1"></script>

<script>
    var tossPayments = TossPayments("test_ck_JQbgMGZzorzzXdypGB7rl5E1em4d");
    var button = document.getElementById("payment-button");

    var orderId = new Date().getTime(); //주문 고유번호
	    
    button.addEventListener("click", function () {
        var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"
		
        var paymentData = {
            amount:${viewInfo.viewLecture.lecturePrice} ,
            orderId: orderId,
            orderName: "${viewInfo.viewLecture.lectureTitle}",
            successUrl: window.location.origin+"${pageContext.request.contextPath}"+"/vod/success?customerName=${memberLogin.memberId}&lectureId=${viewInfo.viewLecture.lectureId}",
            failUrl: window.location.origin+"${pageContext.request.contextPath}"+"/vod/fail",
        };

        if (method === '가상계좌') {
            paymentData.virtualAccountCallbackUrl = window.location.origin + '/virtual-account/callback'
        }

        tossPayments.requestPayment(method, paymentData);
    });
</script>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>


<script>
	let what =1;	// 스크립트 내 변수

	function find_check(num) {
		
		if (num === 1) {
			document.getElementById("findP").style.display = "none";
			document.getElementById("findE").style.display = "";
			what = 1;
		} else {
			document.getElementById("findE").style.display = "none";
			document.getElementById("findP").style.display = "";
			what = 0;
		}
	}
	
	
	function memberFind_click() {
		var emailV = "";	// 결과 이메일 & 스토어 값 저장하기 위한 변수
		if (what === 1) {
			$.ajax({
				type: 'POST',
				url: "${contextPath}/Jaego/findEmail",
		        dataType : "text",
				data: {
					memberName: document.getElementById("inputName_1").value,
					memberPhone: document.getElementById("inputPhone_1").value
				},
				success: function (result) {
					const data = result;
					if(data == "fail"){
						$('#email_value').text("해당하는 정보의 회원이 존재하지 않습니다");
					}else{
						$('#email_value').text(data);
					}
				}
			}) // email 끝
			
		} else {
			$.ajax({
				type: 'POST',
				url: "${contextPath}/Jaego/findPassword",
				dataType : "text",
				data: {
					memberName: document.getElementById("inputName_2").value,
					memberPhone: document.getElementById("inputPhone_2").value,
					memberEmail: document.getElementById("inputEmail_2").value
				},
				success: function (result) {
					const data = result;
					if (data == "fail") {
						$('#password_value').text("해당하는 정보의 회원이 존재하지 않습니다");
					}else{
						// 회원 비밀번호 변경하는거얌.
					}
				}
			}) // password 끝
		}
	}	// memberFind_click() 끝
	
	
	
</script>

<body>

	<%--<%@ include file="/WEB-INF/views/modal/findModal.jsp" --%>
	<div class="full">
		<div class="container">
			<div class="area_inputs wow fadeIn">
		
				<div class="sub_title font-weight-bold mt-3">
					<h1>이메일/비밀번호 찾기</h1><hr> <br> 
				</div>
				<div style="margin-bottom: 10px;"
					class="custom-control custom-radio custom-control-inline" >
					<input type="radio" class="custom-control-input" id="search_1"
						name="search_total" onclick="find_check(1)" checked="checked">
					<label class="custom-control-label font-weight-bold" for="search_1">이메일 찾기</label> 
				</div>
				<div class="custom-control custom-radio custom-control-inline" >
					<input type="radio" class="custom-control-input" id="search_2"
						name="search_total" onclick="find_check(2)">
					<label class="custom-control-label font-weight-bold" for="search_2">비밀번호 찾기</label> 
				</div>
				
				<br>
				<div id="findE">
					<div class="form-group">
						<label class="font-weight-bold" for="inputName_1">이름</label> <form:errors path="memberName"/>
						<div>
							<input type="text" class="form-control" id="inputName_1" style="width:30%;"
								name="inputName_1" placeholder="ex) 장영주">
						</div>
					</div>
					<div class="form-group">
						<label class="font-weight-bold" for="inputPhone_1">휴대폰 번호</label>
						<div>
							<input type="text" class="form-control" id="inputPhone_1" style="width:30%;"
								name="inputPhone_1" placeholder="ex) 01011112222">
						</div>
					</div>
					
					<div class="form-group" style="margin: 2rem 0px;">
					<button id="searchBtn" type="button" onclick="memberFind_click()"
						data-bs-toggle="modal" data-bs-target="#emailModal"
						class="btn btn-primary btn-block">확인</button>
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}/login">취소</a>
					</div>	
									
				</div>
				
				
				<div id="findP" style="display: none;">
					<div class="form-group">
						<label class="font-weight-bold" for="inputName_2">이름</label>
						<div>
							<input type="text" class="form-control" id="inputName_2" style="width:30%;"
								name="inputName_2" placeholder="ex) 장영주">
						</div>
					</div>
					<div class="form-group">
						<label class="font-weight-bold" for="inputEmail_2">이메일</label>
						<div>
							<input type="email" class="form-control" id="inputEmail_2" style="width:30%;"
								name="inputEmail_2" placeholder="ex) E-mail@gmail.com">
						</div>
					</div>
					<div class="form-group">
						<label class="font-weight-bold" for="inputPhone_2">휴대폰 번호</label>
						<div>
							<input type="text" class="form-control" id="inputPhone_2" style="width:30%;"
								name="inputPhone_2" placeholder="ex) 01011112222">
						</div>
					</div>
					
					<div class="form-group" style="margin: 2rem 0px;">
					<button id="searchBtn2" type="button" onclick="memberFind_click()"
						data-bs-toggle="modal" data-bs-target="#passwordModal"
						class="btn btn-primary btn-block">확인</button>
					<a class="btn btn-danger btn-block"
						href="${pageContext.request.contextPath}/login">취소</a>
					</div>
					
				</div>
					

				<!-- eModal -->
				<div class="modal fade" id="emailModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="emailModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="emailModalLabel">회원님의 이메일 정보입니다</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <h5 id="email_value"></h5>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인</button>	 	
				      </div>
				    </div>
				  </div>
				</div>
				
				<!-- pModal -->
				<div class="modal fade" id="passwordModal" tabindex="-1" aria-labelledby="passwordModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="passwordModalLabel">변경할 비밀번호를 입력하세요</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      
				      <div class="modal-body">
				        <label class="font-weight-bold" for="newPassword">새로운 비밀번호</label><br>
						<div>
							<input type="password" class="form-control" id="newPassword" name="newPassword"><br><br>
				      	</div>
				      	<label class="font-weight-bold">비밀번호를 변경하시겠습니까?</label><br>
				      </div>	
				      	
				      <div class="modal-footer">
				        <input type="submit" class="btn btn-primary" data-bs-dismiss="modal" value="확인" formaction="/findPage" >
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
				  	  </div>
					</div>
				  </div>
				</div>
				
				
				
			</div>
		</div>
	</div>
</body>

<%@ include file="/resources/layout/footer.jsp"%>
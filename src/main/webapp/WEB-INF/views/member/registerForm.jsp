<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<script>
function check(){
    var email1=$("#email1").val();
    var email2=$("#email2").val();
    if(email1==''){
   	 alert("이메일을 입력하세요");
   	 return;
    }
    else if(email1.length < 4){
    	alert("이메일은 최소 4자 이상이어야 합니다");
    	return;
    }
    $.ajax({
       type:"post",
       async:false,  
       url:"${contextPath}/Jaego/check.do",
       dataType:"text",
       data: {email1:email1,
    	   	email2:email2
       },
       success:function (data,textStatus){
          if(data=='false'){
       	    alert("사용할 수 있는 이메일입니다.");
       	   // $('#duplicateCheck').prop("disabled", true);
          }else{
        	  alert("존재하는 이메일 입니다.");
          }
       },
       error:function(data,textStatus){
          alert("에러가 발생했습니다.");
       },
       complete:function(data,textStatus){
       }
    });  
 }
 

</script>

<body>
	
	<div class="container mt-3">	
		<div class="context">
			<h1>회원가입</h1>
			<hr>
		
		
		<form:form commandName="memberDto" method="POST">
		<div class="mb-3 mt-3">
		<h3>회원 정보 입력</h3> <br>
		
			<div class="register">
					
					<form:label path="memberName" class="form-label">이름</form:label><form:errors class="mx-3" path="memberName" style="color:#f00;" />
					<form:input path="memberName" class="form-control" style="width:20%;"/>
					
					
					<label class="mt-3">이메일 주소</label>	<button id="duplicateCheck" class ="btn btn-outline-primary m-2" type="button" onClick="check()">중복확인</button>
					<form:errors path="memberEmail1" style="color:#f00;"/>
					
					 <div class="row mt-1">
						 <div class="col-md-3 mb-3">
						<form:input path="memberEmail1" id="email1" class="form-control"/>
						</div>
						<div class="col-md-4 ">
							<div class="input-group mb-3">	
							<span class="input-group-text">@</span>
							<form:select path="memberEmail2" class="form-select" id="email2">
								<form:option value="naver.com" label="naver.com"/>
								<form:option value="gmail.com" label="gmail.com"/>
								<form:option value="hanmail.net" label="hanmail.net"/>
								<form:option value="nate.com" label="nate.com"/>
								<form:option value="hotmail.com" label="hotmail.com"/>
							</form:select>
						</div>
						</div>
					</div>							

					<form:label path="memberPassword" class="form-label" >비밀번호 입력</form:label>		<form:errors class="mx-3" path="memberPassword" style="color:#f00;"/>
					<form:input path="memberPassword" type="password" class="form-control" style="width:20%;"/>
					
					<label class="form-label mt-3">비밀번호 확인</label> <form:errors class="mx-3" path="confirmPassword"/> <label style="color:#f00;"> ${msg} </label> 
					<input name="confirmPassword" type="password" class="form-control" style="width:20%;"> 
					<!-- 비밀번호 확인 ==> AJAX -->
				
				
					<label class="mt-3">연락처</label>
					<div class="row mt-1">
							 <div class="col-md-2 mb-3">
							<form:select path="memberPhone1" class="form-select">	
								<form:option value="010" label="010"/>
								<form:option value="011" label="011"/>
								<form:option value="016" label="016"/>
								<form:option value="017" label="017"/>
								<form:option value="016" label="018"/>
								<form:option value="017" label="019"/>
							</form:select>
							</div>
							<div class="col-md-2 mb-3">
								<div class="input-group">	
								<span  class="input-group-text">-</span>
								<form:input path="memberPhone2" maxlength="4" class="form-control"/>
								<form:errors path="memberPhone2" style="color:#f00;"/>
								</div>
							</div>
							<div class="col-md-2 mb-3">
								<div class="input-group">	
								<span  class="input-group-text">-</span>	
								<form:input path="memberPhone3"  maxlength="4" class="form-control"/>
								<form:errors path="memberPhone3" style="color:#f00;"/>		
								</div>
							</div>
						</div>
					<form:label path="memberGender" class="form-check-label">성별</form:label><form:errors path="memberGender"/>
						<form:select path="memberGender" class="form-select"  style="width:20%;">	
							<form:option value="남" label="남자"/>
							<form:option value="여" label="여자"/>
					</form:select>
				
		
					<form:label path="memberAge" class="form-check-label mt-3">나이</form:label>
						<form:select path="memberAge" class="form-select"  style="width:20%;">	<form:errors path="memberAge"/>
						
							<form:option value="1" label="20세 미만"/>
							<form:option value="2" label="20세 이상 25세 미만"/>
							<form:option value="3" label="25세 이상 30세 미만"/>
							<form:option value="4" label="30세 이상 35세 미만"/>
							<form:option value="5" label="35세 이상 40세 미만"/>
							<form:option value="6" label="40세 이상"/>
						</form:select>
		

			</div>
		
		</div> 
	   		<br><hr>
	   	<div class="submit">
	   		
	   		<input type="submit" value="회원가입" class="btn btn-primary">
	   		<input type="reset" value="리셋" class="btn btn-warning mx-2">
	   		<input type="button" value="취소" class="btn btn-danger mx-2" onclick="history.back()">													
	   	</div>
		</form:form>
	

		
	</div>
	</div>

	
</body>

<%@ include file="/resources/layout/footer.jsp"%>
</html>
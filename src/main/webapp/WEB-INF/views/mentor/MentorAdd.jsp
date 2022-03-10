<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<div class="container">

	<h1 class="text-center"><strong>멘토 등록</strong></h1>
	<form:form commandName="mentor" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/><br>
			 <div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorImg">멘토 사진</form:label></h4>
 	   			<img alt="임의 사진" src="#" width="300" height="300" class="rounded-circle mb-3" onerror="this.src='./resources/icon/logo.jpg'" id="preview" />	
 	   			<form:errors/>		
				<input type="file" name="file" accept="image/jpg,image/jpeg,image/png" class="form-control" id="imgSelector"  />
			</div>
 			<div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorContent">멘토 소개</form:label></h4>	
 	   			<div style="float:right;"><span class="textCount1">0자</span> <span class="textTotal">/250자</span></div>
 	   			
				<form:textarea path="mentorContent" cols="50" rows="5" class="form-control" placeholder="자신을 어필 할 수 있는 소개를 적어주세요" id="mentorContent"/>
				<form:errors path="mentorContent" />
			</div>
			
			<div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorCareer1">경력 (최대 5개)</form:label></h4>
 				<form:input type="text" path="mentorCareer1" class="form-control" placeholder="경력 사항을 적어주세요"/>
				<form:errors path="mentorCareer1" />
				<form:input type="text" path="mentorCareer2" class="form-control mt-3"/>
				<form:errors path="mentorCareer2" />
				<form:input type="text" path="mentorCareer3" class="form-control mt-3"/>
				<form:errors path="mentorCareer3" />
				<form:input type="text" path="mentorCareer4" class="form-control mt-3"/>
				<form:errors path="mentorCareer4" />
				<form:input type="text" path="mentorCareer5" class="form-control mt-3"/>
				<form:errors path="mentorCareer5" />
				
				
				
			</div>
			<div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorLink1">소셜미디어 (최대 3개)</form:label></h4>
				<form:input type="text" path="mentorLink1" class="form-control" placeholder="소셜미디어 링크를 적어주세요"/>
				<form:errors path="mentorLink1" />
				<form:input type="text" path="mentorLink2" class="form-control mt-3"/>
				<form:errors path="mentorLink2" />
				<form:input type="text" path="mentorLink3" class="form-control mt-3"/>
				<form:errors path="mentorLink3" />
			</div>
			<div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorBank">은행 이름</form:label></h4>
				<form:select  path="mentorBank" class="form-control">
				<option value="">은행을 골라주세요</option>
			 		<form:option value="기업은행">기업은행</form:option>
			 		<form:option value="농협은행">농협은행</form:option>
			 		<form:option value="몰라은행">몰라은행</form:option>
			 		<form:option value="알아은행">알아은행</form:option>
			 		<form:option value="지지은행">지지은행</form:option>
				</form:select>
				<form:errors path="mentorBank" />
			</div>
			<div class="mb-3 mt-3">
 	   			<h4><form:label path="mentorAccount">계좌 번호</form:label></h4>
				<form:input type="text" path="mentorAccount" class="form-control"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"/>
				<form:errors path="mentorAccount" />
			</div>
			
		<br>
		<hr>
		 <div class="mb-3 mt-3">
				<button type="submit" class="btn btn-outline-primary mx-2">요청하기</button>
				<button type="reset" class="btn btn-outline-danger mx-2">양식 리셋</button>
			</div>
	</form:form>

</div>


<script type="text/javascript">
$('#imgSelector').change(function(){
    setImageFromFile(this, '#preview');
});
function setImageFromFile(input, expression) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(expression).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
$('#mentorContent').keyup(function (e) { 
	let content = $(this).val();
	if (content.length == 0 || content == '') { 
		$('.textCount1').text('0자'); 
		} else { $('.textCount1').text(content.length + '자');
	} 
	if (content.length > 250) { 
		$(this).val($(this).val().substring(0, 250)); 
		alert('글자수는 250자까지 입력 가능합니다.');
		};
});
</script>


<%@ include file="/resources/layout/footer.jsp"%>

</html>

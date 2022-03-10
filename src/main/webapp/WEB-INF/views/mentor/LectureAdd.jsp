<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<style>
 a { color:black !important; text-decoration:none !important } 
 a:hover { text-decoration:none !important }
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function execDaumPostcode() {
	  new daum.Postcode({
	    oncomplete: function(data) {
	      var fullRoadAddr = data.roadAddress;
	      var extraRoadAddr = ''; 
	      if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	        extraRoadAddr += data.bname;
	      }
	      if(data.buildingName !== '' && data.apartment === 'Y'){
	        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	      }
	      if(extraRoadAddr !== ''){
	        extraRoadAddr = ' (' + extraRoadAddr + ')';
	      }
	      if(fullRoadAddr !== ''){
	        fullRoadAddr += extraRoadAddr;
	      }
	      document.getElementById('zipcode').value = data.zonecode; 
	      document.getElementById('roadAddress').value = fullRoadAddr;
	      document.getElementById('jibunAddress').value = data.jibunAddress;
	      if(data.autoRoadAddress) {
	        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

	      } else if(data.autoJibunAddress) {
	          var expJibunAddr = data.autoJibunAddress;
	          document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	      } else {
	          document.getElementById('guide').innerHTML = '';
	      }
	    }

	  }).open();

	}

</script>


<div class="container">
<h1 class="text-center"><strong>클래스 등록</strong></h1>
<form method="POST" enctype="multipart/form-data">
	 	<input type="hidden" name="mentorId" value="${myMentorId}"/> <!-- 나중에 세션이나 모델을 통해 멘토 아이디를 가져가야하므로 바꿔야함 -->
	 	<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/> <!-- 나중에 세션이나 모델을 통해 멘토 아이디를 가져가야하므로 바꿔야함 -->
	 	    <div class="mb-3 mt-3">
    			<h4>클래스 제목</h4>
    				  <div style="float:right;"><span class="textCount1">0자</span> <span class="textTotal">/20자</span></div>
					  <input type="text" class="form-control" name="lectureTitle"  id="lectureTitle"  size="20" maxlength='20' />
			</div>
			<div class="mb-3 mt-3">
    			<h4>클래스 카테고리</h4>
	 	   		 	<select name="lectureCategory" class="form-select">
									<option value="외국어">외국어</option>
									<option value="커리어">커리어</option>
									<option value="디자인/영상">디자인/영상</option>
									<option value="뷰티/헬스">뷰티/헬스</option>
									<option value="라이프">라이프</option>
								
					</select>
			</div>
	 	    <div class="mb-3 mt-3">
    			<h4>강의 내용</h4>
						<div style="float:right;"><span class="textCount2">0자</span> <span class="textTotal">/500자</span></div>
					<textarea class="form-control h-25" style="resize: none;" rows="10" name="lectureContent" maxlength='500' id="lectureContent"placeholder="-- 주식투자(트레이딩)를 시작하고 싶은 사람들을 위한 수업!!&#13;&#10;-- 주식 단타 트레이딩을 위한 수업~!&#13;&#10;-- 경험은 있지만 뚜렷한 기준이 없는 사람들을 위한 수업??" required/></textarea>
			</div>
	 	    <div class="mb-3 mt-3">
    			<h4>클래스 기간</h4>
					시작 날짜<br> <p> <input class="form-control" type="date" name="lectureStart" required/> </p> 끝나는 날짜 <br>  <p><input class="form-control" type="date" name="lectureEnd" required/> </p>
			</div>	
	 	    <div class="mb-3 mt-3">
	 	   		 <h4>클래스 최대 수용인원 (현재 최대 4인까지)</h4>
	 	   		 	<select name="lectureMaxcount" class="form-select">
									<option value="1">1인</option>
									<option value="2">2인</option>
									<option value="3">3인</option>
									<option value="4">4인</option>
					</select>
			</div>
		    <div class="mb-3 mt-3">
					<h4>강의장 주소</h4> 
					   <input type="text" id="zipcode" name="lectureZipcode" size="10" required/> <button type="button" class="btn btn-outline-primary mx-3"> <a href="javascript:execDaumPostcode();"> 우편번호검색</a></button>
					  <br>
					  <p> 
					   지번 주소:<br><input type="text" id="roadAddress"  name="lectureRoadAddress" size="50" required/><br><br>
					  도로명 주소:<br> <input type="text" id="jibunAddress" name="lectureJibunAddress" size="50" required/><br><br>
					  나머지 주소:<br><input type="text"  name="lectureNamujiAddress" size="50" />
					  </p>
			</div>
			<div class="mb-3 mt-3">
		   <br>
					<h4>시간 당 가격</h4>
					<input class="form-control" type='text' name="lecturePrice" placeholder="시간당 가격 (₩)" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">	(₩)원		
			</div>
			<div class="mb-3 mt-3">
			  <br>
				<h4>클래스 커버 이미지</h4> 
					<img alt="임의 사진" src="#"  width="500" height="300"  class="mx-auto mb-2 d-block " onerror="this.src='./resources/icon/logo.jpg'" id="preview" />			
					<input  type="file" name="lectureImg1" accept="image/jpg,image/jpeg,image/png" class="form-control mt-3" id="imgSelector"  >
			</div>	
			<div class="mb-3 mt-3">
		   <br>
					<h4>클래스 커리큘럼 이미지</h4> 
					<img alt="임의 사진" src="#"  width="500" height="300"  class="mx-auto mb-2 d-block " onerror="this.src='./resources/icon/logo.jpg'" id="preview1"  />			
					<input type="file" name="lectureImg2" accept="image/jpg,image/jpeg,image/png" class="form-control mt-3" id="imgSelector1"  >
			</div>	
			<br>
			
			<hr>
		    <div class="mb-3 mt-3">
				<button type="submit" class="btn btn-outline-primary mx-2">클래스 요청</button>
				<button type="reset" class="btn btn-outline-danger mx-2">양식 리셋</button>
			</div>

</form>

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

$('#imgSelector1').change(function(){
    setImageFromFile1(this, '#preview1');
});

function setImageFromFile1(input, expression) {
    if (input.files) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(expression).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

$('#lectureTitle').keyup(function (e) { 
	let content = $(this).val();
	if (content.length == 0 || content == '') { 
		$('.textCount1').text('0자'); 
		} else { $('.textCount1').text(content.length + '자');
	} 
	if (content.length > 20) { 
		$(this).val($(this).val().substring(0, 20)); 
		alert('글자수는 20자까지 입력 가능합니다.');
		};
});


$('#lectureContent').keyup(function (e) { 
	let content = $(this).val();
	if (content.length == 0 || content == '') { 
		$('.textCount2').text('0자'); 
		} else { $('.textCount2').text(content.length + '자');
	} 
	if (content.length > 500) { 
		$(this).val($(this).val().substring(0, 500)); 
		alert('글자수는 500자까지 입력 가능합니다.');
		};
});

</script> 
<%@ include file="/resources/layout/footer.jsp"%>

</html>

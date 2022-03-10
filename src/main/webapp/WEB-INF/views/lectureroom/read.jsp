<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/resources/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>${lectureroomDto.lectureroomTitle}&nbsp내용</title>
<!-- 
<style type="text/css">
.pagination li{
	margin-right: 10px
} 
.pagination li.active a{
	color:red;
} 
  .pagination{
  	display:inline-flex;
    justify-content: center;
      list-style:none;
  }
  table{
  	margin-bottom: 50px;
  }
</style>
 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        
        //listReply(); // **댓글 목록 불러오기
        listReply2('${param.page}'); // ** json 리턴방식
        
        // ** 댓글 쓰기 버튼 클릭 이벤트 (ajax로 처리)
        $("#btnReply").click(function(){
            var replyContent=$("#replyContent").val();
            //var replyer=$("#replyer").val();
            if(replyContent==""){
            	alert("댓글을 입력해 주세요.");            	
            	$("#replyContent").focus();
            	return;
            }
            /*
            if(replyer==""){
            	alert("작성자를 입력해 주세요.");
            	$("#replyer").focus();
            	return;
            }
            */
            
            var param=$("#frm1").serialize();
            $.ajax({                
                type: "post",
                url: "${pageContext.request.contextPath}/reply/insert",
                data: param,
                success: function(res){
                	console.log(res);
                    alert("댓글이 등록되었습니다.");                    
                    listReply2(1);
                    $("#replyContent").val("");
                   // $("#replyer").val("");
                },
                error:function(error){
                	console.log("에러 :");
                	console.log(error);
                }
            });
        });
        
 

        
    });
    
    // Controller방식
    // **댓글 목록1
    function listReply(page){
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/reply/list?lectureroomId=${lectureroomDto.lectureroomId}&page="+page,
            success: function(result){
            // responseText가 result에 저장됨.
                $("#listReply").html(result);
            }
        });
    }
    
    // RestController방식 (Json)
    // **댓글 목록2 (json)
    function listReply2(page){
    	console.log(page);
    	if(page==""){
    		page=1;
    	}
        $.ajax({
            type: "get",
            //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
           					//	 http://localhost:8080/Jaego/reply/listJson/list?lectureroomId=257
			//http://localhost:8080/Jaego/reply/listJson?lectureroomId=257&page=2           							
            url: "${pageContext.request.contextPath}/reply/listJson?lectureroomId=${lectureroomDto.lectureroomId}&page="+page,
            success: function(result){

                //console.dir(result.totCount);
                /*
                var output = " <table border='1'>";
                	output += " <thead>";
                	output += " <tr>";
                	output += " 	<td>댓글수 : "+result.totCount+" 개</td>";
                	output += " 	</tr>";
                	output += " </thead>";
                	output += " <tbody>";
                */
               
                for(var i in result.list){
                    output += "<tr>";
                    output += "<td style='width:500px;'>작성자: "+result.list[i].replyer;
                    output += "&nbsp;&nbsp;&nbsp;("+result.list[i].regdate+")<br><br>";
                    output += result.list[i].replytext+"<br></td>";
                    output += "<tr>";
                }
                output += " </tbody>";
                output += " <tfoot>";
                output += " <tr>";
                output += " <td colspan='5' style='text-align: center; padding-top: 30px'>"+result.pagination+"</td>";
                output += " </tr>";
                output += " </tfoot>";
                output += "</table>";
                $("#listReply").html(output);
            },error:function(error){
            	console.log("error");
            	console.log(error);
            }
        });
    }
    // **날짜 변환 함수 작성
    function changeDate(date){
        date = new Date(parseInt(date));
        year = date.getFullYear();
        month = date.getMonth();
        day = date.getDate();
        hour = date.getHours();
        minute = date.getMinutes();
        second = date.getSeconds();
        strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        return strDate;
    }
    
</script>
</head>
<body>
<div class="container mt-5 mb-5">
	<div class="row" style="float: none; margin:100 auto;">
	<div class="col-md-6" style="float: none; margin:0 auto;">
	
	<div class="title" style="text-align: center;"> <h1>클래스룸 </h1> </div> <br>
	<table border="1" style="width: 700px">
		<tr>
			<th><label>제목</label></th>
			<td class="form-control" >${myLectureroom.lectureroomTitle}</td>
		</tr>
		<tr>
			<th><label>작성자</label></th>
			<td class="form-control-plaintext" >&nbsp;${myLectureroom.lectureroomWriter}</td>
		</tr>
		<tr>
			<th><label>첨부파일</label></th>
			
			<td class="form-control-plaintext" style="text-align:left">  <a href="${pageContext.request.contextPath}/displayFile2?fileName=${myLectureroom.lectureroomFname}&orignalName=${myLectureroom.lectureroomFname}">
						<c:if test="${not empty myLectureroom.lectureroomFname}">
							<img alt="파일" src="${pageContext.request.contextPath}/resources/icon/filefolder.png" width="20" height="20"  onerror="this.src='./resources/icon/logo.jpg'"/>
						</c:if>
					<c:if test="${empty myLectureroom.lectureroomFname}">
						${myLectureroom.lectureroomFname}
					</c:if> </a></td>	
			
		</tr>
		
		<tr>
			<th>작성일</th>
			<td class="form-control-plaintext">&nbsp;<fmt:formatDate value="${myLectureroom.lectureroomRegdate}" pattern="yyyy-MM-dd HH시 mm분"/></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea readonly class="form-control" cols="20" rows="10" >${myLectureroom.lectureroomContent}</textarea></td>
		</tr>
		
	</table>
	
	<div>
		<div class="text-center button mt-3 5rem">
		<a href="<c:url value="/lectureroom/edit/${myLectureroom.lectureroomId}"/>" class="btn btn-dark mr-3">수정</a>
		<a href="<c:url value="/lectureroom/delete/${myLectureroom.lectureroomId}" /> " class="btn btn-dark mr-3">삭제</a>
		<a href="<c:url value="/lectureroom/list" />?lectureId=${myLectureroom.lectureId}"  class="btn btn-dark mr-3">목록</a>
		</div>
		
		
		<!--  <a href="<c:url value="/lectureroom/reply/${lectureroomDto.lectureroomId}"/>">답글</a>-->
	</div>
	<div>
	
<%-- 	<form:form commandName="lectureroomDto" method="POST">
		<table border="1">
			<tr>
				<th><form:label>댓글 작성자</form:label></th>
				<td><form:input type="text" />
			</tr>
		</table>
	</form:form>
		 --%>
		
	
	</div>
	
	<br><br><hr> <h4><label>댓글 남기기</label></h4>
	<form id="frm1">
	<input type="hidden" name="memberId" value="${sessionScope.memberLogin.memberId}"/>
	
	<div style="width:700px;">
        <br>
		<table border="1" style="width:500px;">
	        <tr>
	        	<th style="width:150px"><label>작성자</label></th> 
	        	<td><label class="form-control-plaintext">${memberLogin.memberName}</label></td>
	        </tr>
	        <tr>
	        	<td colspan="2"><textarea class="form-control" rows="4" cols="30" id="replyContent" name="replyContent" placeholder="댓글을 작성해주세요"></textarea></td>
	        </tr>
        </table>

        <div class="button mt-3 5rem">
        <input type="hidden" name="lectureroomId" value="${lectureroomDto.lectureroomId}" >
        <button type="button" id="btnReply" class="btn btn-outline-dark mr-3">댓글 작성</button>
        </div>
        
   </div>
  
   </form>

	</div>
	</div>	
</div>
	    <!-- **댓글 목록 출력할 위치 -->
   <div id="listReply"></div>	
		
</body>

<%@ include file="/resources/layout/footer.jsp"%>


</html>

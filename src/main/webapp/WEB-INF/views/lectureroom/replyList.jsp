<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
    <table style="width:700px">
        <c:forEach var="row" items="${list}">
        <tr>    
            <td>
                ${row.replyer}(<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>)
                <br>
                ${row.replytext}
            </td>
        </tr>
        </c:forEach>
    </table>
    <c:if test="${empty list }">
    	등록된 댓글이 없습니다.
    </c:if>
</body>
</html>

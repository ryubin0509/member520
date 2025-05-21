<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.id}">
	<c:redirect url ="/login"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
    <h1>성공!</h1>

    <form action="/logout" method="post">
        <button type="submit">로그아웃</button>
    </form>
</body>
</html>

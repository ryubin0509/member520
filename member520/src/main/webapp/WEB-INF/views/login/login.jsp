<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="login" method="post">
        <label for="memberId">아이디:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="memberPw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br><br>

        <button type="submit">로그인</button>
    </form>
</body>
</html>

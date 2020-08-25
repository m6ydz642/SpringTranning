<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	로그인 페이지 입니당
	
	<h1>로그인 처리 페이지 </h1>
	<fieldset>
		<form action="/test/member/login" method="post">
			아이디 <input type="text" name="userid"> <br>
			비밀번호 : <input type="password" name="userpw"> <br>
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="location.href='/test/member/insert'">
 		</form>
	
	</fieldset>
</body>
</html>
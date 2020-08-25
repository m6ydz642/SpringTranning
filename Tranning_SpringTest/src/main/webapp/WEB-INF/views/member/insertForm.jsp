<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome 회원가입</title>
</head>
<body>
웰컴 회원가입

<h1> insertForm.jsp 페이지 </h1>

	
	 <fieldset>
	 
	 	<legend>회원가입</legend>
	 	
	 	<form action="/test/member/insert" method="post">
	 	아이디 : <input type="text" name="userid"> <br>
	 	비번 : <input type="text" name="userpw"> <br>
	 	이름 : <input type="text" name="username"> <br>
	 	이메일 : <input type="text" name="email"> <br>
	 		<input type="submit" value="회원가입">
	 		
	 	</form> 
	 	
	 </fieldset>


</body>
</html>
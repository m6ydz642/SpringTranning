<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�α��� ������ �Դϴ�
	
	<h1>�α��� ó�� ������ </h1>
	<fieldset>
		<form action="/test/member/login" method="post">
			���̵� <input type="text" name="userid"> <br>
			��й�ȣ : <input type="password" name="userpw"> <br>
			<input type="submit" value="�α���">
			<input type="button" value="ȸ������" onclick="location.href='/test/member/insert'">
 		</form>
	
	</fieldset>
</body>
</html>
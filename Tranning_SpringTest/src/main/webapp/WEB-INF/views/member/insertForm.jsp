<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome ȸ������</title>
</head>
<body>
���� ȸ������

<h1> insertForm.jsp ������ </h1>

	
	 <fieldset>
	 
	 	<legend>ȸ������</legend>
	 	
	 	<form action="/test/member/insert" method="post">
	 	���̵� : <input type="text" name="userid"> <br>
	 	��� : <input type="text" name="userpw"> <br>
	 	�̸� : <input type="text" name="username"> <br>
	 	�̸��� : <input type="text" name="email"> <br>
	 		<input type="submit" value="ȸ������">
	 		
	 	</form> 
	 	
	 </fieldset>


</body>
</html>
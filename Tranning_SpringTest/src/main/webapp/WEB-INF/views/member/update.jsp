<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome ȸ������</title>
</head>
<body>
���� ȸ�� ���� 

<h1> update.jsp ������ </h1>

	
	 <fieldset>
	 
	 	<legend>ȸ�� ���� </legend>
	 	<%
	 		// ���� ������ ó�� 
	 		String id = (String)session.getAttribute("userid");
	 	if (id == null) {
	 		response.sendRedirect("/member/login");
	 		
	 	}
	 	
	 	%>
	 	<form action="/test/member/update" method="post">
	 		���̵� : <input type="text" name="userid" value="${memberVO.userid}"> <br>
	 		��� : <input type="text" name="userpw"> <br>
	 		�̸� : <input type="text" name="username" value="${memberVO.username}"> <br>
	 		�̸��� : <input type="text" name="email" value="${memberVO.email}"> <br>
	 		<input type="submit" value="ȸ������">
	 		
	 	</form> 
	 	
	 </fieldset>


</body>
</html>
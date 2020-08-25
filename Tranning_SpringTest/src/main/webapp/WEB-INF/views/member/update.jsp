<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome 회원가입</title>
</head>
<body>
웰컴 회원 수정 

<h1> update.jsp 페이지 </h1>

	
	 <fieldset>
	 
	 	<legend>회원 수정 </legend>
	 	<%
	 		// 세션 데이터 처리 
	 		String id = (String)session.getAttribute("userid");
	 	if (id == null) {
	 		response.sendRedirect("/member/login");
	 		
	 	}
	 	
	 	%>
	 	<form action="/test/member/update" method="post">
	 		아이디 : <input type="text" name="userid" value="${memberVO.userid}"> <br>
	 		비번 : <input type="text" name="userpw"> <br>
	 		이름 : <input type="text" name="username" value="${memberVO.username}"> <br>
	 		이메일 : <input type="text" name="email" value="${memberVO.email}"> <br>
	 		<input type="submit" value="회원가입">
	 		
	 	</form> 
	 	
	 </fieldset>


</body>
</html>
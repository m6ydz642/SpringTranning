<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>member info</h1>
	
	<%
		String id = (String) session.getAttribute("userid");
	
	if (id == null) {
		response.sendRedirect("/member/login");
	}
	%>
	<!-- 컨트롤러에서 정보를 저장해서 jsp페이지까지 이동 완료 -->
	
	<h3>아이디 : ${memberVO.userid }</h3>
	<h3>비밀번호 : ${memberVO.userpw } </h3>
	<h3>이름 : ${memberVO.username } </h3>
	<h3>이메일 :$ {memberVO.email } </h3>
	<h3>회원 가입일 : ${memberVO.regdate }</h3>
	
</body>
</html>
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
	<!-- ��Ʈ�ѷ����� ������ �����ؼ� jsp���������� �̵� �Ϸ� -->
	
	<h3>���̵� : ${memberVO.userid }</h3>
	<h3>��й�ȣ : ${memberVO.userpw } </h3>
	<h3>�̸� : ${memberVO.username } </h3>
	<h3>�̸��� :$ {memberVO.email } </h3>
	<h3>ȸ�� ������ : ${memberVO.regdate }</h3>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<font size="5">doF �� : ${value}</font>
	<br>
	
	Ʋ����ȣ�� �԰��� -> <%=request.getAttribute("value") %> <!-- �������� ������ (������ �����Ǽ� ��򸮳�) -->
</body>
</html>
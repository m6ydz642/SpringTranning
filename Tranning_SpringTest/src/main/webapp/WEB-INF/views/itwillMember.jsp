<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<font size="5">itwill! member</font>
	
	<h1> ��� ������ ���� ��ü�� Ȯ�� </h1>
	
	<h1> addAttribute ����� �̸� ���� ���� </h1>
	
	<!--  �ش� Ŭ���� Ÿ���� �빮�ڷ� �̷���� �̸��϶� ù���� �ҹ��� ���� X -->
	<h2>�̸� : ${ITWillBean.name}</h2>
	<h2>���� : ${ITWillBean.tel}</h2>
	<h2>���� : ${iTWillBean.age}</h2>
	<hr>
	
	<h1> addAttribute ����� �̸� ����(itwill) ���� </h1>
	<h2>�̸� : ${itwill.name}</h2> <!-- ��Ʈ�ѷ����� ������ Ű������ -->
	<h2>���� : ${itwill.tel}</h2>
	<h2>���� : ${itwill.age}</h2>

	
	
</body>
</html>
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
	
	<h1> 멤버 페이지 전달 객체값 확인 </h1>
	
	<h1> addAttribute 실행시 이름 없이 저장 </h1>
	
	<!--  해당 클래스 타입이 대문자로 이루어진 이름일때 첫글자 소문자 변경 X -->
	<h2>이름 : ${ITWillBean.name}</h2>
	<h2>전번 : ${ITWillBean.tel}</h2>
	<h2>나이 : ${iTWillBean.age}</h2>
	<hr>
	
	<h1> addAttribute 실행시 이름 포함(itwill) 저장 </h1>
	<h2>이름 : ${itwill.name}</h2> <!-- 컨트롤러에서 전달한 키값으로 -->
	<h2>전번 : ${itwill.tel}</h2>
	<h2>나이 : ${itwill.age}</h2>

	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/main.jsp</h1>


	<%
		// ���ǰ� üũ
		String id = (String) session.getAttribute("userid");
		
		// ���ǰ��� ������� 
		if (id == null) {
			response.sendRedirect(request.getContextPath() + "/member/login");
		}
	%>
	<!-- jsp ǥ���� (�ڹ��ڵ��� ������ �����ؼ� ȭ�鿡 ���) -->
	<%-- <h3><%=id %> ���� �α��� �ϼ̽��ϴ�</h3> --%>
	
	<!-- el ǥ���� (������ �����͸� �����ؼ� ȭ�鿡 ���) -->
	<!-- 
	  el ǥ���� ��밡���� ���尴ü (p517~)
	  
	  pageScope
	  requestScope
	  sessionScope
	  applicationScope
	  
	  param $ (param.�Ķ���� �̸� )
	  paramValues 
	
	 -->
	 <!-- ���尴ü ����.�Ӽ��� -->
	<h3>${ sessionScope.userid } ���� �α��� �ϼ̽��ϴ�</h3>
	 <!-- ���尴ü ����.�Ӽ��� (���� ��ü�� �����̸��� ���� ����)-->
	 <!-- ���尴ü ����
	    (pageScope > requestScope > sessionScope > applicaionScope)��
	     ��� ���������� �˻� 
	     ���࿡ ���� ���Ǵ� �Ӽ��� ������� ���� ������ �˻��� ���� �ʴ´�.
	      -->
	<h3>${ userid } ���� �α��� �ϼ̽��ϴ�</h3>


	<hr>
	
	<input type="button" value="�α׾ƿ�" onclick="location.href='/member/logout' ">
																	<!-- ��Ĺ ���� �ٲ㼭 test��� �ʿ���� -->
	
	<hr>
	
	<h3> <a href="/member/info"> ȸ�� ���� ���� (select) </a> </h3>
	
	
	<hr>
	
	<h3> <a href="/member/update"> ȸ�� ���� ���� (update) </a> </h3>
	
		<hr>
	
	<h3> <a href="/member/delete"> ȸ�� ���� ���� (delete) </a> </h3>
	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%
	session.invalidate();
	out.println("<script>alert('�α׾ƿ� �Ϸ�. �������� �̵��մϴ�.'); window.location='./mainPageJSP.jsp';</script>");
	%>
	
</body>
</html>
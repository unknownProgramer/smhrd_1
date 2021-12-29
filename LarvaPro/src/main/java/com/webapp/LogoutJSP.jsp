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
	out.println("<script>alert('로그아웃 완료. 메인으로 이동합니다.'); window.location='./mainPageJSP.jsp';</script>");
	%>
	
</body>
</html>
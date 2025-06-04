<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int count = (Integer)request.getAttribute("count"); %>
	
	<%for(int i=1;i<=count;i++){%>
	<a href="page2?type=<%=i %>">Value<%=i%></a><br>
	<%} %>
</body>
</html>
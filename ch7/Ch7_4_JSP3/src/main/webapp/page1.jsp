<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page  import="java.util.ArrayList"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<String> datas = (ArrayList)request.getAttribute("data"); %>
	<select name="fruit">
	
		<%for(String fruit : datas){ %>
		<option value="<%=fruit%>"><%=fruit%></option>		
		<%} %>
	
	</select>
</body>
</html>
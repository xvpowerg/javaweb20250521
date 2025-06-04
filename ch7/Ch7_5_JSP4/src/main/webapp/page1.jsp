<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.com.bean.Student" %>
<!DOCTYPE html>
<html>
<head>


<style>

.box{
   border: 2px solid #4CAF50;
   padding: 16px;
   margin-bottom:24px;
   border-radius:8px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student st1 = (Student)session.getAttribute("st1");
		Student st2 = (Student)application.getAttribute("st2");
	%>
	<div class="box">
		Student1:<%=st1 %>
	</div>
	<div class="box">
		Student2:<%=st2 %>
	</div>
</body>
</html>
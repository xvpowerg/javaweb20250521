<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "tw.com.bean.Item" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Item item = (Item)session.getAttribute("item1"); %>
	<h1>Item</h1>
	<p><%=item.getName()%>:<%=item.getPrice()%></p>
	
	<h1>Item EL</h1>
	<p>name:${item1.name}</p>
	<p>price:${item1.price} </p>
	
	<h2>UserList</h2>
	<p>userList:${userList}</p>
	
	<c:forEach var="myUser" items="${userList}">
			<p>name:${myUser.name}</p>
			<p>name:${myUser.age}</p>
	</c:forEach>
	
	<h2>Map</h2>
	<p>name:${userMap.user1.name} </p>
	<p>age:${userMap.user1.age} </p>
	
	<p>name:${userMap["my user2"].name }</p>
	<p>age:${userMap["my user2"].age }</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color="red">	ID 	Firstname	Lastname	Balance		Email</font><br>
	<c:forEach items="${custlist}" var="item">
  		<c:out value="${item.id}"/> <c:out value="${item.firstname}"/> <c:out value="${item.lastname}"/>
  		<c:out value="${item.balance}"/><c:out value="${item.email}"/> <br>
	</c:forEach>
</body> 
</html>
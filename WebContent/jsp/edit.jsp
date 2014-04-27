<%@ page language="java" import="org.asr.model.Customer" contentType="text/html; charset=ISO-8859-1"
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
			<% Customer customer = (Customer)request.getAttribute("editCustomer"); %>
			<form action="EditCustomer" method="post">
				Customer ID: <input type="text" name="id" size="20" value="<%= customer.getId()%>" readonly="readonly"><br>
				Customer Firstname: <input type="text" name="firstname" size="20" value="<%=customer.getFirstname() %>"><br>
				Customer Lastname: <input type="text" name="lastname" size="20" value="<%=customer.getLastname() %>"><br>
				Customer Email: <input type="text" name="email" size="20" value="<%=customer.getEmail() %>"><br>
				Customer Balance: <input type="text" name="balance" size="20" value="<%=customer.getBalance()%>"><br>
				<input type="submit">		
			</form>
			
</body>
</html>
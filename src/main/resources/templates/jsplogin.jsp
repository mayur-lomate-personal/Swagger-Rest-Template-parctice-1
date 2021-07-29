<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
<!-- <p th:text=${SPRING_SECURITY_LAST_EXCEPTION.message}/> -->
<div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
<form action="login" method="POST">
<sec:csrfInput />
<table>
<tr>
<td>User : </td>
<td><input type="text" name="username" value=""></td>
</tr>
<tr>
<td>Password : </td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="submit"></td>
</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Confirmation</title>
</head>
<body>
<h2>Wellcome to our company,<%=session.getAttribute("name") %></h2>

<p>You can now log in <a href="login.jsp">here.</a> </p>
</body>
</html>
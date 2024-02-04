<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<a href="logout" onclick="return confirm('Are you sure you want to log out?')">Logout</a> <br>
	<a href="deleteaccount" onclick="return confirm('Are you sure you want to delete your account? This action cannot be undone.')">Delete Your Profile</a>

 </div>
<a href="subject.jsp">go back</a>
</body>
</html>
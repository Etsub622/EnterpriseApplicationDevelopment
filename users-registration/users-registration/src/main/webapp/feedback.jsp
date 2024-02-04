<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Feedback</h1>
        <hr>

        <h2 class="mt-4">The correct Answer is: <%= session.getAttribute("correctAnswer") %></h2>
        <h3>Your answer is: <%= session.getAttribute("result") %></h3>

        <a href="userPages.jsp?subject=EAD" class="btn btn-primary mt-3">Go Back</a>
    </div>
</body>
</html>

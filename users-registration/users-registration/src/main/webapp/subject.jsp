<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
            max-width: 600px; /* Adjust max-width to match user side */
        }
        .navbar {
            margin-bottom: 20px;
        }
        .navbar-brand {
            color: #333;
            margin-right: auto; /* Pushes the brand to the left */
        }
        .navbar-nav {
            margin-left: auto;
        }
        .nav-link {
            color: #333;
        }
        .subject-list {
            margin: 20px;
            padding: 10px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.3);
            display: inline-block;
        }
        .subject-list a {
            display: block;
            padding: 10px 20px;
            text-decoration: none;
            color: #333333;
        }
    </style>
</head>

<a class="navbar-brand" href="editAdminAccount.jsp"><Strong>Admin Panel</Strong></a>
<body>

<div class="container">
    <h1>Select a subject to create questions on it</h1>

    <div class="subject-list">
        <a href="createQuestion.jsp?subject=EAD">EAD</a>
    </div>
    <div class="subject-list">
        <a href="createQuestion.jsp?subject=Requirement">Requirement</a>
    </div>
    <div class="subject-list">
        <a href="createQuestion.jsp?subject=SPM">SPM</a>
    </div>
    <div class="subject-list">
        <a href="createQuestion.jsp?subject=ML">ML</a>
    </div>
</div>

</body>
</html>

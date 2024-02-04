<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subject Selection</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0; /* Added background color for clarity */
        }
        h1 {
            margin-bottom: 20px;
        }
        .subject-list {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap; /* Allows subjects to wrap to the next line if needed */
        }
        .subject {
            background-color: #add8e6; /* Light blue background color */
            padding: 10px;
            margin: 5px; /* Adjust margin for spacing between subjects */
        }
        .home-link {
            position: absolute;
            top: 10px;
            left: 10px;
        }
    </style>
</head>
<body>
<a class="home-link" href="index.jsp">Home</a>
    <h1>You can select from the following subjects and do the questions, enjoy it!</h1>

    <div class="subject-list">
        <div class="subject"><a href="userPages.jsp?subject=EAD">EAD</a></div>    
        <div class="subject"><a href="userPages.jsp?subject=Requirement">Requirement</a></div>
        <div class="subject"><a href="userPages.jsp?subject=SPM">SPM</a></div>
        <div class="subject"><a href="userPages.jsp?subject=ML">ML</a></div>
    </div>
</body>
</html>
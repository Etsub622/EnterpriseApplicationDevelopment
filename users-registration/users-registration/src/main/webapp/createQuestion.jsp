<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Bank</title>

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<a href="CreateEADJsp.jsp">see the list first?</a>

<body>
<%
  String subject = request.getParameter("subject");
%>

<div class="container mt-5">
    <h1 class="mb-4">Create <%=subject %> Multiple Choice Question</h1>

    <form action="createQuestion" method="post">
        <div class="form-group">
            <label for="question">Enter your question:</label>
            <input type="text" class="form-control" id="question" name="question" required>
        </div>

        <div class="form-row">
            <div class="col-sm-3 form-group">
                <label for="optionA">A.</label>
                <input type="text" class="form-control" id="optionA" name="optionA" required>
            </div>

            <div class="col-sm-3 form-group">
                <label for="OptioinB">B.</label>
                <input type="text" class="form-control" id="OptioinB" name="OptioinB" required>
            </div>
        </div>S

        <div class="form-row">
            <div class="col-sm-3 form-group">
                <label for="optionC">C.</label>
                <input type="text" class="form-control" id="optionC" name="optionC" required>
            </div>

            <div class="col-sm-3 form-group">
                <label for="optionD">D.</label>
                <input type="text" class="form-control" id="optionD" name="optionD" required>
            </div>
        </div>

       <div class="col-sm-3 form-group">
            <label for="answer" pattern="[A-D]">Enter the answer</label>
            <input type="text" class="form-control" id="answer" name="answer" required>
        </div>

        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js CDN (optional, for Bootstrap features that require them) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Question</title>
    
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Question</h1>
        
        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions", "root", "root");
            int id = Integer.parseInt(request.getParameter("id"));
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT question, optionA, optioinB, optionC, optionD, answer FROM new_table WHERE questionId = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
        %>

        <form action="editServlet" method="post">
            <input type="hidden" name="id" value="<%=id%>">

            <div class="form-group ">
                <label for="question">Question:</label>
                <input type="text" class="form-control" name="question" value="<%= rs.getString("question") %>">
            </div>

            <div class="form-group col-sm-3">
                <label for="optionA">Option A:</label>
                <input type="text" class="form-control" name="optionA" value="<%= rs.getString("optionA") %>">
            </div>

            <div class="form-group col-sm-3">
                <label for="OptioinB">Option B:</label>
                <input type="text" class="form-control" name="OptioinB" value="<%= rs.getString("OptioinB") %>">
            </div>

            <div class="form-group col-sm-3">
                <label for="optionC">Option C:</label>
                <input type="text" class="form-control" name="optionC" value="<%= rs.getString("optionC") %>">
            </div>

            <div class="form-group col-sm-3">
                <label for="optionD">Option D:</label>
                <input type="text" class="form-control" name="optionD" value="<%= rs.getString("optionD") %>">
            </div>

            <div class="form-group col-sm-3">
                <label for="answer">Answer:</label>
                <input type="text" class="form-control" name="answer" value="<%= rs.getString("answer") %>">
            </div>

            <button type="submit" class="btn btn-primary">Edit</button>
        </form>

        <%      
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </div>

    <!-- Bootstrap JS and Popper.js CDN (optional, for Bootstrap features that require them) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
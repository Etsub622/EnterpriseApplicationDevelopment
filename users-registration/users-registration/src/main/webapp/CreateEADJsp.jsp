<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Question Bank</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body> 
      
   <br>
    <div>
    <a href="createQuestion.jsp?subject=EAD">
     CREATE NEW QUESTION
    </a>
    <br>
    <br>
    <a href="subject.jsp">
     Home
    </a>
    
     </div>
     
    <div class="container mt-4">
        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions", "root", "root");
            
            Statement st = conn.createStatement();
            String query = "select * from new_table";
            ResultSet rs = st.executeQuery(query);

          
            int questionCounter = 1; // Initialize the question counter outside the loop
          
            while (rs.next()) {
            	
        %>  
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title"><Strong>Question <%= questionCounter %></Strong></Strong></h5>
                        <p class="card-text"><%= rs.getString("question") %></p>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Option A:</strong> <%= rs.getString("optionA") %></li>
                            <li class="list-group-item"><strong>Option B:</strong> <%= rs.getString("OptioinB") %></li>
                            <li class="list-group-item"><strong>Option C:</strong> <%= rs.getString("optionC") %></li>
                            <li class="list-group-item"><strong>Option D:</strong> <%= rs.getString("optionD") %></li>
                        </ul>
                        <p class="card-text"><strong>Answer:</strong> <%= rs.getString("answer") %></p>
                        <a href='Edit.jsp?id=<%= rs.getInt("questionId") %>' class="btn btn-primary">Edit</a>
                        <a href='deleteServlet?id=<%= rs.getInt("questionId") %>' class="btn btn-danger ml-2">Delete</a>
                    </div>
                </div>
        <%
            questionCounter++;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
        }
        %> 
    </div>

    <!-- Bootstrap JS and Popper.js CDN (optional, for Bootstrap features that require them) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

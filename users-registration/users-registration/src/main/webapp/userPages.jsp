<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Multiple Choice Questions</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>
<%
    String subject = request.getParameter("subject");
    if (subject != null && (subject.equalsIgnoreCase("EAD") || subject.equalsIgnoreCase("ead"))) {
%>
    <a class="navbar-brand" href="userSelection.jsp">Home</a>
    <div class="container">
        <h1>Multiple Choice Questions</h1>

        <% try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions", "root", "root");
            String query = "select * from new_table";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            int counter = 1;
            while (rs.next()) {
        %>
                <form action="checkanswer?id=<%=rs.getInt("questionID") %>" method="post" class="mt-4" onsubmit="return validateAnswer('<%= rs.getInt("questionID") %>');">
                    <fieldset>
                        <legend><%=counter%>. <%=rs.getString("question") %></legend>
                        
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="question_<%= rs.getInt("questionID")%>_option"  value="A" id="optionA<%= rs.getInt("questionID")%>">
                            <label class="form-check-label" for="optionA<%= rs.getInt("questionID")%>">A. <%=rs.getString("optionA") %></label><br>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="question_<%= rs.getInt("questionID")%>_option"  value="B" id="optionB<%= rs.getInt("questionID")%>">
                            <label class="form-check-label" for="optionB<%= rs.getInt("questionID")%>">B. <%=rs.getString("OptioinB") %></label><br>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="question_<%=rs.getInt("questionID") %>_option" value="C" id="optionC<%= rs.getInt("questionID")%>">
                            <label class="form-check-label" for="optionC<%= rs.getInt("questionID")%>">C. <%=rs.getString("optionC") %></label><br>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="question_<%=rs.getInt("questionID") %>_option" value="D" id="optionD<%= rs.getInt("questionID")%>">
                            <label class="form-check-label" for="optionD<%= rs.getInt("questionID")%>">D. <%=rs.getString("optionD") %></label><br>
                        </div>
                        <input type="submit" name="Check Answer" class="btn btn-primary mt-2">
                    </fieldset>
                </form>
        <% 
                counter++;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </div>

    <script>
        function validateAnswer(questionID) {
            var options = document.getElementsByName("question_" + questionID + "_option");
            var optionSelected = false;
            for (var i = 0; i < options.length; i++) {
                if (options[i].checked) {
                    optionSelected = true;
                    break;
                }
            }
            if (!optionSelected) {
                alert("Please choose an answer for question " + questionID);
                return false;
            }
            return true;
        }
    </script>
<%
   } else {
%>
    <div class="container">
        <h1>Page Not Created Yet</h1>
        <p>The page you are looking for is not created yet. It will be created soon.</p>
        <a href="userSelection.jsp?">go back </a>
                
    </div>
<%
    }
%>
</body>
</html>
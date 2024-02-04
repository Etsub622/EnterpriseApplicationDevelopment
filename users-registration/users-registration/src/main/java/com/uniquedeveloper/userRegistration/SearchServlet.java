package com.uniquedeveloper.userRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/SearchServlet")

public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");

        // Perform the search operation based on the subject
        List<String> searchResults = searchSubjects(subject);

        // Store the search results in a request attribute
        request.setAttribute("searchResults", searchResults);

        // Forward the request to the searchResults.jsp page
        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }

    private List<String> searchSubjects(String subject) {
        List<String> results = new ArrayList<>();

        // Connect to the database
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration", "root", "root")) {
            // Prepare the SQL query
            String sql = "SELECT result FROM subjects WHERE subject = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, subject);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the search results
            while (resultSet.next()) {
                String result = resultSet.getString("result");
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
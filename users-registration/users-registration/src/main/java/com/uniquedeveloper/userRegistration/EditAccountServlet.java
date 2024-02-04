package com.uniquedeveloper.userRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/editAccount")

public
 
class
 
EditAccountServlet
 
extends
 
HttpServlet
 
{
    private static final long serialVersionUID = 1L;


    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Get the user id from the session
        String userIdString = (String) session.getAttribute("id");
        String password = (String) session.getAttribute("password");

        if (userIdString != null) {
            int userId = Integer.parseInt(userIdString);
            String username = request.getParameter("username");
            String name = request.getParameter("name");

            // Check username availability before updating
            if (isUsernameAvailable(username, userId)) {
                if (updateUserAccount(userId, username, name, password)) {
                    // Update the username in the session
                    session.setAttribute("username", username);
                    session.setAttribute("name", name);

                    session.setAttribute("editStatus", "success");
                } else {
                    session.setAttribute("editStatus", "failed");
                }
            } else {
                session.setAttribute("editStatus", "taken");

            }
        } else {
            session.setAttribute("status", "failed");
            
           
        } response.sendRedirect("userPage.jsp");
        
    }

    private boolean isUsernameAvailable(String username, int userId) {
        String checkQuery = "SELECT COUNT(*) FROM users WHERE username = ? AND id != ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration?useSSL=false", "root", "root");
             PreparedStatement statement = connection.prepareStatement(checkQuery)) {
            statement.setString(1, username);
            statement.setInt(2, userId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count == 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean updateUserAccount(int userId, String username, String name, String password) {
        String updateQuery = "UPDATE users SET username = ?, name = ?, password = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration?useSSL=false", "root", "root");
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, username);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setInt(4, userId);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

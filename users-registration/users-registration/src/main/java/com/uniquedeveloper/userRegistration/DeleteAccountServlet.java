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
import java.sql.SQLException;

/**
 * Servlet implementation class DeleteAccountServlet
 */

@WebServlet("/deleteaccount")
public class DeleteAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Get the user id from the session
        String userIdString = (String) session.getAttribute("id");
        
        if (userIdString != null) {
            int userId = Integer.parseInt(userIdString); // Convert the user id to an int
            
            // Call a method to delete the user's account using the userId
            boolean deleted = deleteUserAccount(userId);
            
            if (deleted) {
                // Account deleted successfully
                session.invalidate(); // Invalidate the session
                response.sendRedirect("login.jsp"); // Redirect to a page indicating successful deletion
            } else {
                // Account deletion failed
                response.sendRedirect("userPage.jsp"); // Redirect to a page indicating deletion failure
            }
        } else {
            // Handle the case where user id is not found in the session
            response.sendRedirect("userPage.jsp");
        }
    }

    private boolean deleteUserAccount(int userId) {
        String deleteQuery = "DELETE FROM users WHERE id = ?";
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration", "root", "root");
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, userId);
            
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0; // Return true if deletion is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception or deletion failure
        }
    }
}
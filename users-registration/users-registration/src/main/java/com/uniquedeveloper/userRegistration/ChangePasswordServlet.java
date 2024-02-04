package com.uniquedeveloper.userRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userregistration?useSSL=false";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Retrieving username, name, and old password from the session
        String username = (String) session.getAttribute("username");
        String name = (String) session.getAttribute("name");
        String oldPassword = (String) session.getAttribute("password");

        // Retrieving user input for old and new passwords
        String enteredOldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        PrintWriter out = response.getWriter();

        if (enteredOldPassword != null && enteredOldPassword.equals(oldPassword)) {
            if (!newPassword.equals(oldPassword)) {
                // Update password in the database
                try {
                    Connection conn = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);

                    String updateQuery = "UPDATE users SET password = ? WHERE username = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
                    preparedStatement.setString(1, newPassword);
                    preparedStatement.setString(2, username);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        // Update password in the session
                        session.setAttribute("password", newPassword);
                        session.setAttribute("editPwdStatus", "success");
                        response.sendRedirect("changePassword.jsp");
                    } else {
                        session.setAttribute("editPwdStatus", "failure");
                        response.sendRedirect("changePassword.jsp");
                    }

                    preparedStatement.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    session.setAttribute("editPwdStatus", "failure");
                    response.sendRedirect("changePassword.jsp");
                }
            } else {
                session.setAttribute("editPwdStatus", "same password");
                response.sendRedirect("changePassword.jsp");
            }
        } else {
            session.setAttribute("editPwdStatus", "incorrect");
            response.sendRedirect("changePassword.jsp");
        }
    }
}
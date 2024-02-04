package com.uniquedeveloper.userRegistration;

import jakarta.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration?useSSL=false", "root", "root");

            // Check if username is already taken
            PreparedStatement checkUsernameStmt = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username=?");
            checkUsernameStmt.setString(1, username);
            ResultSet resultSet = checkUsernameStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                dispatcher = request.getRequestDispatcher("signUp.jsp");
                request.setAttribute("status", "taken");
                System.out.print(request.getAttribute("status"));
                dispatcher.forward(request, response);
                return; // Stop further execution
            }

            PreparedStatement pst = con.prepareStatement("INSERT INTO users(name, username, password) VALUES(?, ?, ?)");
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, password);

            int rowCount = pst.executeUpdate();
            
            dispatcher = request.getRequestDispatcher("signUp.jsp");

            if (rowCount > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
            }

        } catch (Exception e) {
             e.printStackTrace();
        } finally {
             try {
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
        }

        dispatcher.forward(request, response);
    }
}

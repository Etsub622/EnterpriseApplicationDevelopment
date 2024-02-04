package com.uniquedeveloper.userRegistration;

import jakarta.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public LoginServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userregistration?useSSL=false", "root", "root");
			PreparedStatement pst = con.prepareStatement("select * from users where username = ? and password = ?");
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				session.setAttribute("username", rs.getString("username"));
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("password", rs.getString("password"));
				session.setAttribute("id", rs.getString("id"));
				
//				dispatcher = request.getRequestDispatcher("index.jsp");
				
			        if ("Admin".equals(username) && "Admin".equals(password)) {
			            // Redirect to index.jsp
			            
			            response.sendRedirect("subject.jsp");
			        } else {
			            // Redirect to subject.jsp
			        	response.sendRedirect("index.jsp");
			            
			        }
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	

}

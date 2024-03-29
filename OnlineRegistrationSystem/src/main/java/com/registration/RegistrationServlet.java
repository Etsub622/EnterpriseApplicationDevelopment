package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet {
	private static final String DB_URL =
	"jdbc:mysql://localhost:3306/userdb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp){
//retrieve form data
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn =
	
	DriverManager.getConnection(
	DB_URL,
	DB_USER,
	DB_PASSWORD);
	String query = "insert into users(name, email, password)values(?,?,?)";
	PreparedStatement pstmt =
	
	conn.prepareStatement(query);
	
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	pstmt.setString(3, password);
	pstmt.executeUpdate();
	conn.close();
	
	HttpSession session = req.getSession();
	session.setAttribute("name", name);
	
	resp.sendRedirect("confirmation.jsp");
	}catch (SQLException se) {
	    se.printStackTrace();
	    
	
	} catch (Exception e) {
	    e.printStackTrace();
	
	
	}
	}
}
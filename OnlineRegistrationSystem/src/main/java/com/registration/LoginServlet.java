package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final String DB_URL =
	"jdbc:mysql://localhost:3306/userdb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp){
	String email = rq.getParameter("email");
	String password = rq.getParameter("password");
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn =
	
	DriverManager.getConnection(
	DB_URL, DB_USER, DB_PASSWORD);
	String query = "select * from users where email = ? AND password = ?";
	
	PreparedStatement pstmt =
	
	conn.prepareStatement(query);
	
	pstmt.setString(1, email);
	pstmt.setString(2, password);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
	//authentication successful
	conn.close();
	rp.sendRedirect("welcome.jsp");
	}else {
	//authentication failed
	conn.close();
	rp.sendRedirect("login.jsp");
	}
	
	}catch (SQLException se) {
	    se.printStackTrace();
	    
	
	} catch (Exception e) {
	    e.printStackTrace();
	
	
	}
	}
}

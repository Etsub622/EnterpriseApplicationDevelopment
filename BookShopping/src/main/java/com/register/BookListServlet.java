package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/list")

public class BookListServlet extends HttpServlet {
	  public static final String query = "SELECT ID,BookName, BookEdition, BookPrice FROM bookregister";

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        PrintWriter pw = res.getWriter();
	        res.setContentType("text/html");

	       

	        // Loading JDBC
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	        } catch (ClassNotFoundException cnf) {
	            cnf.printStackTrace();

	        }

	        // Connection
	        try (Connection con = DriverManager.getConnection("jdbc:mysql:///book", "root", "root");
	             PreparedStatement ps = con.prepareStatement(query);) {
	        	ResultSet rs=ps.executeQuery();
	        	pw.println("<table>");
	        	pw.println("<tr>");
	        	
	        	pw.println("<th>Book ID</th>");
	        	pw.println("<th>Book Name</th>");
	        	pw.println("<th>Book Edition</th>");
	        	pw.println("<th>Book Price</th>");
	        	pw.println("<th>Edit</th>");
	        	pw.println("<th>Delete</th>");
	        	
	        	pw.println("</tr>");
	        	
	        	while (rs.next()) {
	        		pw.println("<tr>");
	        		pw.println("<td>"+rs.getInt(1)+"</td>");
	        		pw.println("<td>"+rs.getString(2)+"</td>");
	        		pw.println("<td>"+rs.getString(3)+"</td>");
	        		pw.println("<td>"+rs.getFloat(4)+"</td>");
	        		pw.println("<td><a href='editscreen?id="+rs.getInt(1)+"'>Edit</a></td >");
	        		pw.println("<td><a href='deleteservlet?id="+rs.getInt(1)+"'>Delete</a></td >");
	        		pw.println("</tr>");
	      	
	        	}
	        	
                 pw.println("</table>");
                 

	        } catch (SQLException se) {
	            se.printStackTrace();
	            pw.println("<h1>" + se.getMessage() + "</h1>");

	        } catch (Exception e) {
	            e.printStackTrace();
	            pw.println("<h1>" + e.getMessage() + "</h1>");

	        }
	        
	        pw.println("<a href='Home.html'>Home</a>");
	    }

}

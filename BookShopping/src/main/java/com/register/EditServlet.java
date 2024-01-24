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
@WebServlet("/editservlet")

public class EditServlet extends HttpServlet {

	public static final String query = "update bookregister set BookName=?, BookEdition=?, BookPrice=? where id= ?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");    
        
//    	get the id of the query 
        int id= Integer.parseInt(req.getParameter("id"));
    	
    	String BookName=req.getParameter("BookName");
    	String BookEdition=req.getParameter("BookEdition");
    	float BookPrice=Float.parseFloat(req.getParameter("BookPrice"));
    	

        // Loading JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();

        }

        // Connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///book", "root", "root");
             PreparedStatement ps = con.prepareStatement(query);) {
        	ps.setString(1, BookName);
        	ps.setString(2, BookEdition);
        	ps.setFloat(3,BookPrice);
        	ps.setInt(4, id);
        	int count=ps.executeUpdate();
        	if(count==1) {
        		
        	    pw.println("<h2>Record edited successfuly</h2>");
        		}else {
        			pw.println("<h2>Record is not edited,try again later!</h2>");
        			
        		}

        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h1>");

        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h1>");

        }
        
        pw.println("<a href='Home.html'>Home</a>");
        pw.println("<br>");
        pw.println("<a href='list'>Book List</a>");
        
}
    }

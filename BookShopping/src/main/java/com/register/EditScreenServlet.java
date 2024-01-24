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

@WebServlet("/editscreen")
public class EditScreenServlet extends HttpServlet {
	public static final String query = "SELECT BookName, BookEdition, BookPrice from bookregister where id=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        
//    	get the id of the query 
    	int id=Integer.parseInt(req.getParameter("id"));

        // Loading JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();

        }

        // Connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///book", "root", "root");
             PreparedStatement ps = con.prepareStatement(query);) {
        	ps.setInt(1, id);
        	ResultSet rs=ps.executeQuery();
        	rs.next();

        	
        	pw.println("<form action = 'editservlet?id="+id+"' method='get'>");
        	
        	pw.println("<table align='center'>");
        	
        	
        	
        		pw.println("<tr>");
        		pw.println("<td>Book Name</td>");
        		pw.println("<td><input type='text' name='BookName' value='"+rs.getString(1)+"'></td>");
        		pw.println("</tr>");
        		
        		pw.println("<tr>");
        		pw.println("<td>Book Edition</td>");
        		pw.println("<td><input type='text' name='BookEdition' value='"+rs.getString(2)+"'></td>");
        		pw.println("</tr>");
        		
        		pw.println("<tr>");
        		pw.println("<td>Book Price</td>");
        		pw.println("<td><input type='text' name='BookPrice' value='"+rs.getFloat(3)+"'></td>");
        		pw.println("</tr>");
      	
        		pw.println("<td><input type='submit' value='Edit'></td>");
        		pw.println("<td><input type='reset' value='cancel'></td>");
        	
             pw.println("</table>");
             pw.println("</form>");
             

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

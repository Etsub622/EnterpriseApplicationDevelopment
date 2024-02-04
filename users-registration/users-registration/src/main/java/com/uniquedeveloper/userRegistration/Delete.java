package com.uniquedeveloper.userRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteServlet")
public class Delete extends HttpServlet {
	private static final String query="delete from new_table where questionID=?";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions","root","root");
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int count=ps.executeUpdate();
			if(count==1) {
				pw.println("<h2>Deleted Successfully.</h2>");
			}
			else {
				pw.println("<h2>It's not deleted Successfully.</h2>");	
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		response.sendRedirect("CreateEADJsp.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

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



 
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
	private static final String query="update new_table set question=?,optionA=?,OptioinB=?,optionC=?,optionD=?,answer=? where questionID=?";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter pw = response.getWriter();
		

		int id=Integer.parseInt(request.getParameter("id"));
		String question=request.getParameter("question");
		String optionA=request.getParameter("optionA");
		String OptioinB= request.getParameter("OptioinB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String answer=request.getParameter("answer");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions","root","root");
			PreparedStatement psmt=conn.prepareStatement(query);
			psmt.setString(1,question);
			psmt.setString(2,optionA);
			psmt.setString(3, OptioinB);
			psmt.setString(4, optionC);
			psmt.setString(5, optionD);
			psmt.setString(6, answer);
			psmt.setInt(7, id);
			
			int count=psmt.executeUpdate();
			if(count==1) {
				pw.println("<h>Question edited successfuly.</h2>");
			}
			else {
				pw.println("<h>Question is not edited,try again.</h2>");
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1>" + se.getMessage() + "</h1>");
	    } catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("<h1>" + e.getMessage() + "</h1>");
	    
	    }
		response.sendRedirect("CreateEADJsp.jsp");
		}
	}




package com.uniquedeveloper.userRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/createQuestion")
public class CreateQuestion extends HttpServlet {      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String question =request.getParameter("question");
		String optionA=request.getParameter("optionA");
		String OptioinB=request.getParameter("OptioinB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String answer=request.getParameter("answer");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions","root","root");
			
			String query="insert into new_table(question,optionA,OptioinB,optionC,optionD,answer)values(?,?,?,?,?,?)";	
			PreparedStatement psmt=conn.prepareStatement(query);
			
			psmt.setString(1,question);
			psmt.setString(2, optionA);
			psmt.setString(3, OptioinB);
			psmt.setString(4, optionC);
			psmt.setString(5, optionD);
			psmt.setString(6, answer);
		
			psmt.executeUpdate();
			conn.close();
			response.sendRedirect("confirmation.jsp");
					
		}catch (Exception e){
			e.printStackTrace();
			response.getWriter().println("An error occurred: " + e.getMessage());
			
		}	
	}
}

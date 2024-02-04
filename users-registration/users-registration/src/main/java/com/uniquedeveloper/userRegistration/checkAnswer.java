package com.uniquedeveloper.userRegistration;

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


@WebServlet("/checkanswer")
public class checkAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkAnswer() {
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
		String id=request.getParameter("id");
		String answerParameter="question_"+id+"_option";
		String userAnswer=request.getParameter(answerParameter);
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quesions","root","root");
			String query="select answer from new_table where questionID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String correctAnswer=rs.getString("answer");
				boolean isCorrect=userAnswer.equals(correctAnswer);
				
				String result;
				if(isCorrect) {
					result="correct!";
				}else {
					result="incorrect!";
				}
				
				HttpSession session=request.getSession();
				session.setAttribute("correctAnswer", correctAnswer);
				session.setAttribute("result",result);
		}
			conn.close();
			response.sendRedirect("feedback.jsp");
				
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}

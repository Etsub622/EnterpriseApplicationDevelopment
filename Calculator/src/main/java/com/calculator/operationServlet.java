package com.calculator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.calculator.*;
/**
 * Servlet implementation class operationServlet
 */
@WebServlet("/operation")
public class operationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operationServlet() {
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
		
		String operation = request.getParameter("operation");

        if ("add".equals(operation)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/addition");
            dispatcher.forward(request, response);
        } else if ("multi".equals(operation)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/multiply");
            dispatcher.forward(request, response);
        }  else if ("sub".equals(operation)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/difference");
            dispatcher.forward(request, response);
        }  else if ("divid".equals(operation)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/divide");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Invalid operation");
 }
 }

}

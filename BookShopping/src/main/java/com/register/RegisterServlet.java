package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public static final String query = "INSERT INTO bookregister(BookName, BookEdition, BookPrice) VALUES(?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String BookName = req.getParameter("BookName");
        String BookEdition = req.getParameter("BookEdition");
        float BookPrice = Float.parseFloat(req.getParameter("BookPrice"));

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
            ps.setFloat(3, BookPrice);

            int count = ps.executeUpdate();
            if (count == 1) {
                pw.println("<h1>Record registered successfully</h1>");
            } else {
                pw.println("<h1>Record is not registered.</h1>");
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
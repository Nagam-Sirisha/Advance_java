package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateBookById")
public class UpdateBookById extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName=req.getParameter("bookName");
		String bookAuthor=req.getParameter("bookAuthor");
		int bookCost = Integer.parseInt(req.getParameter("cost"));
		int bookPages = Integer.parseInt(req.getParameter("pages"));
		
		
		PrintWriter printWriter = resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE hr SET bookName=?,bookAuthor=?,cost=?,pages=? WHERE bookId=?");
			
			preparedStatement.setString(1,bookName);
			preparedStatement.setString(1,bookAuthor);
			preparedStatement.setInt(1, bookCost);
			preparedStatement.setInt(1, bookPages);
			preparedStatement.setInt(1, bookId);
			
			preparedStatement.executeUpdate();
			
			HttpSession session=req.getSession();
			session.setAttribute("name", name);
			
			resp.sendRedirect("Homepage");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
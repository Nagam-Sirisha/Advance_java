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

@WebServlet("/AddBook")
public class AddBook extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String bookName = req.getParameter("name");
		String bookAuthor = req.getParameter("authorname");
		int cost = Integer.parseInt(req.getParameter("cost"));
		int pages = Integer.parseInt(req.getParameter("pages"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books VALUES(?,?,?,?,?)");
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3, bookAuthor);
			preparedStatement.setInt(4, cost);
			preparedStatement.setInt(5, pages);
			
			int result = preparedStatement.executeUpdate();
			
			PrintWriter printWriter = resp.getWriter();
			if(result==1)
			{
				//printWriter.println("Details Added successfully");
				resp.sendRedirect("AddBook.html");
			}else {
				printWriter.println("Please enter details");
			}
			
			HttpSession session=req.getSession();
			session.setAttribute("name", name);
			
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		resp.sendRedirect("AddBook.html");
	}
}

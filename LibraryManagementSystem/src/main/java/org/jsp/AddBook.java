package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBook extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String bookName = req.getParameter("name");
		String bookAuthor = req.getParameter("authorname");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books VALUES(?,?,?)");
			
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3, bookAuthor);
			
			int result = preparedStatement.executeUpdate();
			PrintWriter printWriter = resp.getWriter();
			if(result==1)
			{
				//printWriter.println("Details Added successfully");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AddBook.html");
				dispatcher.forward(req, resp);
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}

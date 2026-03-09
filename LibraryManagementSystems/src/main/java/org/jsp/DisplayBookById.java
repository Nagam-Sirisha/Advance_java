package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayBookById")
public class DisplayBookById extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter printWriter = resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE bookId=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			printWriter.println("<html>");
			printWriter.println("<body>");
			printWriter.println("<h2>Book details</h2>");
			if(resultSet.next())
			{
				printWriter.println("<h4>Book id: "+id+"</h4>");
				printWriter.println("<h4>Book Name: "+resultSet.getString("bookName")+"</h4>");
				printWriter.println("<h4>Book Author: "+resultSet.getString("bookAuthor")+"</h4>");
				printWriter.println("<h4>Book Cost: "+resultSet.getInt("cost")+"</h4>");
				printWriter.println("<h4>No of pages: "+resultSet.getInt("pages")+"</h4>");
			}
			else {
				printWriter.println("<h3>No book is found with id: "+id+"</h3>");
			}
			printWriter.println("<form action='Homepage' method='post'>"
								+ "<button>Homepage</button>"
								+ "</form>");
			printWriter.println("</body>");
			printWriter.println("</html>");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

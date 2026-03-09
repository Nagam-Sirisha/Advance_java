package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBookById")
public class DeleteBookById extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("bookId"));
		PrintWriter printWriter = resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE bookId=?");
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			
			if(result==1) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("DeleteBookById");
				dispatcher.forward(req, resp);
			}
			else {
			printWriter.println("<html>");
			printWriter.println("<body>");
			printWriter.println("<h2>No book found.</h2>");
			printWriter.println("</body>");
			printWriter.println("</html>");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

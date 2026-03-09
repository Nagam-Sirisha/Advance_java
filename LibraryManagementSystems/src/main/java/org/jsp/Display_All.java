package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Display_All")
public class Display_All  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<body>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root","root");
			String query = "SELECT * FROM books";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
				do {
					int book_id = resultSet.getInt("bookId");
					String book_name = resultSet.getString("bookName");
					String book_author = resultSet.getString("bookAuthor");
					int book_cost = resultSet.getInt("cost");
					int book_pages = resultSet.getInt("pages");
					String result = "Book [ Id: "+book_id+" ,Name :"+ book_name +" ,Author :"+book_author
							+" ,cost: "+book_cost +" ,pages: "+book_pages+ " ]";
					printWriter.println("<h4>"+result+"</h4>");
					printWriter.println("<form action = 'delete' method='get'>"+"<input type='hidden' value="+book_id+"name='id'>"
							+"<button>Delete</button></form>" );
				}while(resultSet.next());
			}else {
				printWriter.println("<h1>Books are not available at the movement try again later</h1>");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}printWriter.println("</body>");
		printWriter.println("</html>");
	}
}

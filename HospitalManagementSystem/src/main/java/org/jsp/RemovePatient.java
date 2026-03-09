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

public class RemovePatient extends HttpServlet
{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		PrintWriter printWriter = resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM patient WHERE id=? ");
			
			preparedStatement.setInt(1,id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0)
			{
//				printWriter.println("removed");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("Homepage");
//				dispatcher.forward(req, resp);
			
				RequestDispatcher dispatcher = req.getRequestDispatcher("RemovePatient.html");
				dispatcher.forward(req, resp);
			}else {
				printWriter.println("<html>");
				printWriter.println("<body>");
				printWriter.println("<h2>No patients dound Id: "+id+"</h2>");
				printWriter.println("</body>");
				printWriter.println("</html>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

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

public class PatientForm extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		long number=Long.parseLong(req.getParameter("number"));
		String email=req.getParameter("email");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patient VALUES(?,?,?,?,?)");
			
			preparedStatement.setString(1,id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, address);
			preparedStatement.setLong(4,number);
			preparedStatement.setString(5, email);
			
			int result = preparedStatement.executeUpdate();
			PrintWriter printWriter = resp.getWriter();
			if(result==1)
			{
				//printWriter.println("Details Added successfully");
				RequestDispatcher dispatcher = req.getRequestDispatcher("PatientDetails.html");
				dispatcher.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

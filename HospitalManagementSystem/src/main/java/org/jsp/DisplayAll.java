package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayAll extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM patient";
			ResultSet resultSet = statement.executeQuery(sql);
			PrintWriter out=res.getWriter();
			while(resultSet.next())
			{
				out.println("Id : "+resultSet.getInt("id"));
				out.println("Name : "+resultSet.getString("name"));
				out.println("Address : "+resultSet.getString("address"));
				out.println("Phone Number : "+resultSet.getLong("number"));
				out.println("Email : "+resultSet.getString("email"));
				out.println("--------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}

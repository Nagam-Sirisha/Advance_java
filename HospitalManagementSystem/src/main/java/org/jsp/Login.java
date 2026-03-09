package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalsystem","root","root");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user where email=?");
			
			PrintWriter out=res.getWriter();
			
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				String dbPassword = resultSet.getString("password");
				if(dbPassword.equals(password)){
					/*out.println("<h1>Name</h1>");
					out.println("<input type='text' value='name'>");
					out.println("<h1>Email</h1>");
					out.println("<input type='email' value='example@gmail.com'>");
					out.println("<h1>Password</h1>");
					out.println("<input type='password' value='password'>");
					out.println("<h1>Number</h1>");
					out.println("<input type='tel' value='9875425623'>");
					out.println("<button>Delete</button> <button>Update</button>");*/
					RequestDispatcher dispatcher = req.getRequestDispatcher("Homepage");
					dispatcher.forward(req, res);
					
				}else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
					out.println("<h1>Invalid password</h1>");
					dispatcher.include(req, res);
				}
			}
			else{
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				out.println("<h1>Invalid email</h1>");
				dispatcher.include(req, res);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}	
	}	
}
package org.jsp.EstablishConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnectionWay1
{
	public static void main(String[] args) 
	{
		try {
			//step-1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step-2
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_connection?user=root&&password=root");
			System.out.println("Connection successful");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

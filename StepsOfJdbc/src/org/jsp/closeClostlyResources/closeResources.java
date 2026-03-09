package org.jsp.closeClostlyResources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class closeResources
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet bro = null;
		try {
			// step-1 Load and register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_connection";
			String username = "root";
			String password = "root";
			//step-2 Create connection
			connection = DriverManager.getConnection(url, username, password);
			//step-3 create Statement
			statement = connection.createStatement();
		
			String sql = "SELECT * FROM users";
			// step-4 execute SQL queries
			bro = statement.executeQuery(sql);
			
			while(bro.next())
			{
				System.out.println("Id: "+bro.getInt(1));
				System.out.println("Name: "+bro.getString("name"));
				System.out.println("Email: "+bro.getString("email"));
				System.out.println("Password: "+bro.getString("password"));
				System.out.println("------------------------------------------");
			}
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(bro!=null)
				try {
					//step-5 close the costly resources
					//closing the ResultSet
					bro.close();
					//closing Statement
					statement.close();
					//closing Connection
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}

package org.jsp.SingletonJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonJDBC 
{
	private static Connection connection;
	private SingletonJDBC(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_connection";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if(connection==null)
			new SingletonJDBC();
		return connection;
	}
}

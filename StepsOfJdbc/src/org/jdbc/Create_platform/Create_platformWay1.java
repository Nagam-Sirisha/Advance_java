package org.jdbc.Create_platform;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create_platformWay1
{
	public static void main(String[] args) 
	{
		try {
			// step-1
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step -2
			String url="jdbc:mysql://localhost:3306/jdbc_connection";
			String username="root";
			String password="root";
			Connection connection= DriverManager.getConnection(url, username, password);
			
			//step-3
			java.sql.Statement statement= connection.createStatement();
			
			//step-4
			//String sql="CREATE TABLE users(id int(10) primary key,name varchar(50),email varchar(50) unique,password varchar(50))";
			//statement.execute(sql);
			//System.out.println("table created");
			
			//step-5
			/*String sql="INSERT INTO users VALUES(1,'hanuman','hanuman@gmail.com','hanuman123')";
			statement.execute(sql);
			System.out.println("values inserted");*/
			
			/*String sql="INSERT INTO users VALUES(2,'ram','ram@gmail.com','ram123')";
			statement.execute(sql);
			System.out.println("values inserted");*/
			
			/*String sql="INSERT INTO users VALUES(3,'sita','sita@gmail.com','sita123')";
			statement.execute(sql);
			System.out.println("values inserted");*/
			
			/*String sql="SELECT * FROM users";
			statement.execute(sql);
			System.out.println("table");*/
			
			/*String sql2="UPDATE users SET email='sitaram@gmail.com' where id=3";
			statement.execute(sql2);
			System.out.println("value updated");*/
			
			/*String sql="DELETE FROM users WHERE id=2";
			statement.execute(sql);
			System.out.println("deleted value");*/
			
			String sql = "UPDATE users SET password='pass'";
			statement.execute(sql);
			System.out.println("deleted value");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

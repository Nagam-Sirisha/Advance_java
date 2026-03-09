package executeStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class ExecuteQuery
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_connection";
			String username = "root";
			String password = "root";
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();
			
			String sql = "SELECT * FROM users where id = 3";
			ResultSet bro = statement.executeQuery(sql);
			
			if(bro.next())
			{
				System.out.println("Id: "+bro.getInt(1));
				System.out.println("Name: "+bro.getString("name"));
				System.out.println("Email: "+bro.getString("email"));
				System.out.println("Password: "+bro.getString("password"));
				System.out.println("------------------------------------------");
			}
			else
			{
				throw new UserNotFoundExecption("No user found");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

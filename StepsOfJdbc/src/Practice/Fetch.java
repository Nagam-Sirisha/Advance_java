package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/jdbc_connection";
		String username="root";
		String password="root";
		String sql = "SELECT * FROM users";
		try(Connection connection=DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql))
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			while(set.next())
			{
				System.out.println("name: "+ set.getInt("id"));
				System.out.println("name: "+set.getString("name"));
				System.out.println("Username: "+set.getString("email"));
				System.out.println("password: "+set.getString("password"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

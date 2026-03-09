package ProjectBasedOnSteps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass 
{
	public static void main(String[] args) 
	{
		System.out.println("Select one option:");
		System.out.println("1. Insert values in database");
		System.out.println("2. Update the value in database");
		System.out.println("3. Delete the value in database");
		System.out.println("4. exit");
		int choice = ScannerClass.scanner.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc_connection";
			String username="root";
			String password="root";
			Connection connection= DriverManager.getConnection(url, username, password);
			java.sql.Statement statement= connection.createStatement();
			switch (choice) {
			case 1:
			{
				System.out.println("enter id: ");
				int id=ScannerClass.scanner.nextInt();
				System.out.println("enter name");
				String name=ScannerClass.scanner.next();
				System.out.println("enter email");
				String email=ScannerClass.scanner.next();
				System.out.println("enter password");
				String password2=ScannerClass.scanner.next();
				String sql="INSERT INTO users()";
				statement.execute(sql);
				System.out.println("table created");
			}
				break;
			case 2:
			{
				
			}
				break;
			case 3:
			{
				
			}
				break;
			case 4:
			{
				
			}
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

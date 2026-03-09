package org.jsp.loadandregisterdriver;

public class LoadAndRegisterDriverClassWay2 
{
	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Load and Register driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

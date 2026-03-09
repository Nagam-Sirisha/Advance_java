package org.jsp;

public class BroswerFactory 
{
	public static Browser createBrowser(String name)
	{
		switch (name) {
		case "chrome":
			return new Chrome();
		case "edge":
			return new Edge();
		case "brave":
			return new Brave();
		default:
			throw new RuntimeException("Invalid Browser");
		}
	}
}

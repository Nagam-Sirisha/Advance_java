 package org.jsp;

public class MainClass
{
	public static void main(String[] args) 
	{
		Browser browser = BroswerFactory.createBrowser("opera");
		browser.open();
		
	}
}

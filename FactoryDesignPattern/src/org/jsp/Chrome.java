package org.jsp;

public class Chrome implements Browser
{
	private String name = "chrome"; 
	@Override
	public void open() {
		System.out.println("Opening "+name);
		
	}
	
}

package org.jsp;

public class Brave implements Browser
{
	private String name = "brave"; 
	@Override
	public void open() {
		System.out.println("Opening "+name);
		
	}
	
}

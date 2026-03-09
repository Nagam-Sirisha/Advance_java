package org.jsp;

public class Edge implements Browser
{
	private String name = "edge"; 
	@Override
	public void open() {
		System.out.println("Opening "+name);
		
	}
	
}

package com.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/Servlet2" , loadOnStartup = 7)
public class Servlet2 extends HttpServlet
{
	public Servlet2()
	{
		System.out.println("First step executed2");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Second step executed2");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("Third step executed2");
		System.out.println(name);
		RequestDispatcher dispatcher = req.getRequestDispatcher(name);
		dispatcher.forward(req, res);
	}
	@Override
	public void destroy() {
		System.out.println("forth step executed2");
	}
	
}

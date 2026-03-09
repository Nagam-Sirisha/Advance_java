package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/lifecycle",loadOnStartup = 5)
public class ServletLifecycle extends GenericServlet
{
	public ServletLifecycle()
	{
		System.out.println("First step executed1");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Second step executed1");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("Third step executed1");
		System.out.println(name);
		PrintWriter printWriter = res.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<form action='Servlet2'><input type='text' name='name'>");
		printWriter.println("<button>Submit</button");
		printWriter.println("</form></body></html>");
		RequestDispatcher dispatcher = req.getRequestDispatcher(name);
		dispatcher.forward(req, res);
	}
	@Override
	public void destroy() {
		System.out.println("forth step executed1");
	}
}

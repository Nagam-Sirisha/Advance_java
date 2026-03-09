package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Sum extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long num1 = Long.parseLong(req.getParameter("num1"));
		long num2 = Long.parseLong(req.getParameter("num2"));
		
		PrintWriter printWriter = resp.getWriter();
		long sum = num1+num2;
		printWriter.println("<html><body>");
		printWriter.println("<h1>Addition is : "+sum+"</h1>");
		
		printWriter.println("<form action='square'><button>Square</button></form>");
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("sum", sum);
		
		printWriter.println("</body></html");
		
	}
}

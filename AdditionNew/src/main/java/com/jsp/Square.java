package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/square")
public class Square extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Long sum = (Long)httpSession.getAttribute("sum");
		Long square=sum*sum;
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<h2>Square is :"+square+" </h2>");
		printWriter.println("<form action='divide' method='post'><button>Divide</button></form>");
		printWriter.println("</body></html>");
		httpSession.setAttribute("square",square);	
		
	}
}

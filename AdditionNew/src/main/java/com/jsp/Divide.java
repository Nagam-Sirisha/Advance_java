package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/divide")
public class Divide extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Long square = (Long)httpSession.getAttribute("square");
		
		PrintWriter printWriter = resp.getWriter();
		Long divide = square/0;
		printWriter.println("<html><body>");
		printWriter.println("<h2>Divide by 2 is:"+divide+"</h2>");
		printWriter.println("</body></html>");		
	}
}

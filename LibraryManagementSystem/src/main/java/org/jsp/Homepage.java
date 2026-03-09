package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Homepage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");

		out.print("<h1>Hi...." + name + "</h1>");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<button><a href='AddBook.html'>Add Book</a></button><br>");
		out.println("<button>Display book by id</button><br>");
		out.println("<button>Remove book by id</button><br>");
		out.println("<button>Display all books</button><br>");
		out.println("<button>Update book by id</button><br>");
		out.println("</body>");
		out.println("</html>");
		
	}
}

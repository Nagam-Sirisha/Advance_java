package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");

		out.print("<h1>Hi...." + name + "</h1>");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<button><a href='AddBook.html'>Add Book</a></button><br>");
		out.println("<button><a href='DisplayBookById.html'>Display book by id</a></button><br>");
		out.println("<button><a href='DeleteBookById.html'>Remove book by id</a></button><br>");
		out.println("<button><a href='Display_All'>Display all books</a></button><br>");
		out.println("<a href='updateBookById'><button>Update Book By Id</button></a>");
		out.print("<a href='profile'><button>Profile</button></h1>");
		out.print("<a href='logout'><button>Logout</button></h1>");
		out.println("</body>");
		out.println("</html>");	
	}
}

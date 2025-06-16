package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		context.setAttribute("value1", "Test1");
		context.setAttribute("value2", 12345);
		context.setAttribute("value3", "ABCD");
		context.setAttribute("value4", "YUIO");
		
		context.removeAttribute("value3");
		context.setAttribute("value4", "User100");
		resp.getWriter().println("Page1");
		
		
		
		
	}
}

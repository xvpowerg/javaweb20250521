package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =   resp.getWriter();
		out.println("Page1!");
		String type = req.getParameter("type");
		HttpSession session = req.getSession();
		switch(type) {
		case "1":
			session.setAttribute("type", "forward");
			req.getRequestDispatcher("/page2").
			forward(req, resp);
			break;
		case "2":
			session.setAttribute("type", "Redirect");
			resp.sendRedirect("page2");
			break;
		}
		
	}
}

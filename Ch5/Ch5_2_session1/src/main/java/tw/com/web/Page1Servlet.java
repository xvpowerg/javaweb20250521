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
		// TODO Auto-generated method stub
		PrintWriter out =
				resp.getWriter();
		Student st1 = new Student("Ken",18);
		HttpSession session =  req.getSession();
		session.setAttribute("student", st1);
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='page2'>Page2</a>");
		out.println("</body>");
		out.println("</html>");
		
	}
}

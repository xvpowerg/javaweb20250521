package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

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
		String countStr =  req.getParameter("count");
		PrintWriter  out =  resp.getWriter();
		int count = Integer.parseInt(countStr);
		out.println("<html>");
		 out.println("<body>");
			for (int i =1; i<=count;i++) {
				String url = String.format("<a href='page2?type=%d'>Value %d</a> <br>", 
								i,i);
				out.println(url);
			}
		 out.println("</body>");
		out.println("</html>");
	}
}

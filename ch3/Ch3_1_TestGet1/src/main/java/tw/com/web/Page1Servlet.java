package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  out  =   resp.getWriter();
		String name = req.getParameter("name");
		String count = req.getParameter("count");
		
		if (name == null || count ==null ) {
			out.print("Empty");
		}
		
		int countInt = Integer.parseInt(count);
		//out.print("Page1:"+name+":"+count);
		out.print("<html>");
		out.print("<body>");
		for (int i =1; i<= countInt;i++) {
			out.print("<p>");
			out.print("i:"+i);
			out.print("name:"+name);
			out.print("</p>");
		}
		out.print("</body>");
		out.print("</html>");
		
	}
}

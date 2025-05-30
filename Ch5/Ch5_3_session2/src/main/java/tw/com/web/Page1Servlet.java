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
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out =  resp.getWriter();
		 HttpSession  session = req.getSession();
		 Object countObj = session.getAttribute("count");
		 int count = 1;
		 if (countObj == null) {
			 session.setAttribute("count", count);
		 }else {
			 count = (int)session.getAttribute("count") ;
			 count++;
			 session.setAttribute("count", count);
		 }
		 out.println("Page1:"+count);
		 
	}
}

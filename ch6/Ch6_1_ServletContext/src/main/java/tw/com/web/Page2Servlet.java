package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter  out =   resp.getWriter();
		HttpSession session =  req.getSession();
		ServletContext context = getServletContext();
		String msgConext = (String)context.getAttribute("msg");
		String msgSession = (String)session.getAttribute("msg");
		
		out.println("msgConext:"+msgConext);
		out.println("msgSession:"+msgSession);
		
	}
}

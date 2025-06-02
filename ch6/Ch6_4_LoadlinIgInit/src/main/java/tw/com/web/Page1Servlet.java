package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/page1"},loadOnStartup = 1)
public class Page1Servlet extends HttpServlet {
	
		@Override
		public void init() throws ServletException {
		// TODO Auto-generated method stub
			
			System.out.println("Page1Servlet Init....Start");
			
			
			try {
				TimeUnit.SECONDS.sleep(10);
			}catch(Exception ex) {
			
			}
			
			
			System.out.println("Page1Servlet Init....End");
			System.out.println("page1 init");
		}
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			PrintWriter  out =   resp.getWriter();
			out.println("Page1");
		}
}

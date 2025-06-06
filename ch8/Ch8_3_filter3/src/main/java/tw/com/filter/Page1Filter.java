package tw.com.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/mypage/page1")
public class Page1Filter extends HttpFilter  {
	@Override
	public void  doFilter(HttpServletRequest req,HttpServletResponse response,FilterChain cain)
			throws IOException{
		Object obj = req.getParameter("count");
		if (obj == null) {
			response.sendRedirect("../page1_error.html");
			return;
		}
		
			try {
				cain.doFilter(req, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}

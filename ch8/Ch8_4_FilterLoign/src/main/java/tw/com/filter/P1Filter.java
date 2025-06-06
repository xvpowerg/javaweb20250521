package tw.com.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebFilter("/p1/*")
public class P1Filter extends HttpFilter {
	public void doFilter(HttpServletRequest resuest,HttpServletResponse respons,FilterChain chain) throws IOException {
		HttpSession session =  resuest.getSession();
		Optional login =  Optional.ofNullable(session.getAttribute("login"));
		if (login.isPresent()) {
			try {
				chain.doFilter(resuest, respons);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		respons.sendRedirect("../p2/login.html");
	}
}

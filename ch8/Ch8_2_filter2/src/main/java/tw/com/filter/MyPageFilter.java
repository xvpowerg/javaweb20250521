package tw.com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/mypage/*")
public class MyPageFilter implements Filter {
	public void   doFilter(ServletRequest req,ServletResponse respon,FilterChain chain) {
		respon.setContentType("text/html;charset=utf-8");
		try {
			chain.doFilter(req,respon);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

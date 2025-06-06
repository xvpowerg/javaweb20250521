package tw.com.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
@WebFilter("/mypage/*")
public class Page1Filter  implements Filter{
	
	public void doFilter(ServletRequest req,ServletResponse resop,FilterChain cain) {
		
		System.out.println("Page1Filter! 1");
		try {
			cain.doFilter(req, resop);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			System.out.println(false);
		}
		System.out.println("Page1Filter! 2");
		
	}
}

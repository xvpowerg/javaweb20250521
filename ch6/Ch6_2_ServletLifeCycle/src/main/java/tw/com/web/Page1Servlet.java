package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	
	private ArrayList<Integer> list = new ArrayList<>();
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		for(int i =1; i<=100;i++) {
			list.add(i);
		}
		
		System.out.println("Page1Servlet:init():"+this.hashCode());
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  out =  resp.getWriter();
		out.println("MyList:"+list);
		out.println("DoGet:"+this.hashCode());
		out.println("ThreadName:"+Thread.currentThread().getName());
	}
}

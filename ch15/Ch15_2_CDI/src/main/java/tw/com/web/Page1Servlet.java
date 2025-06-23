package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.beans.MyApple;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Inject
	@Named("redApple")
	private MyApple apple;
	
	@Inject
	@Named("appleList")
	private ArrayList<MyApple> appleList;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Contexts and Dependency Injection
		System.out.println(apple);
		System.out.println(appleList);
	}
}

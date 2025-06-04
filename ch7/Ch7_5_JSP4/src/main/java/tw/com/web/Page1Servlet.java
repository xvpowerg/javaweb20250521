package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.bean.Student;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  req.getSession();	
		Student student1 = new Student("Ken",16);
		ServletContext context = getServletContext();
		Student student2 = new Student("Iris",12);
		session.setAttribute("st1", student1);
		context.setAttribute("st2", student2);
		req.getRequestDispatcher("/page1.jsp").forward(req, resp);
		
	}
}

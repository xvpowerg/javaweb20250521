package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mypage/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strCount = req.getParameter("count");
		int count = Integer.parseInt(strCount);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/page1.jsp").forward(req, resp);
	}
}

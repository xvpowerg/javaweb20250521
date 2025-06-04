package tw.com.web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		String data = req.getParameter("data");
		String[] array = data.split(",");
		for(String f:array) {
			arrayList.add(f);
		}
		req.setAttribute("data", arrayList);
		req.getRequestDispatcher("/page1.jsp").forward(req, resp);
	}
}

package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.com.bean.Item;
import tw.com.bean.User;
import java.util.HashMap;
@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  req.getSession();
		Item item = new Item("Apple",180);
		session.setAttribute("item1", item);
		
		
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("User1",21));
		list.add(new User("User2",18));
		list.add(new User("User3",16));
		list.add(new User("User4",25));
		session.setAttribute("userList", list);
		
		HashMap<String,User> userMap = new HashMap<>();
		
		userMap.put("user1", new User("user1",17));
		userMap.put("my user2", new User("user2",25));
		
		ServletContext app = this.getServletContext();
		app.setAttribute("userMap",userMap);
		
		
		
		req.getRequestDispatcher("/page1.jsp").
		forward(req, resp);
		
	}
}

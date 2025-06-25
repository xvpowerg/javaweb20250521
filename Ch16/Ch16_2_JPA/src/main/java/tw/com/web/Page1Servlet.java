package tw.com.web;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;


@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	
	@EJB
	private MyUserBeanLocal myUsetBean;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyUser myUser = new MyUser();
		//System.out.println(myUser);
		myUser.setAccount("ken");
		myUser.setPassword("123456");
		myUsetBean.regisrter(myUser);
		//System.out.println(myUser);
		
		MyUser myUser2 = new MyUser();
		myUser2.setAccount("Iris");
		myUser2.setPassword("123456");
		myUsetBean.regisrter(myUser2);
		
//Delete		
//		boolean delete = myUsetBean.deleteUser(myUser2);
//		System.out.println("delete:"+delete);
//Update		
//		myUser2.setPassword("78923");
//		boolean update = myUsetBean.updateUser(myUser2);
//		System.out.println("update:"+update);
		
		MyUser myUser3 = myUsetBean.findUserByAccount("ken", "123456");
		System.out.println("findUser:"+myUser3);
		
	}
}

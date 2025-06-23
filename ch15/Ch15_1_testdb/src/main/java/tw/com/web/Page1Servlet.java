package tw.com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.db.DbTools;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean b1 = DbTools.regisrter("Lucy", "123456");
		System.out.println(b1);
		// TODO Auto-generated method stub
//		String url = "jdbc:mysql://localhost:3306/testdb20250623?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
//		String user = "root";
//		String password = "123456";
//		try(Connection conn  =  DriverManager.getConnection(url,user,password);
//			Statement stem =	conn.createStatement();){
//			stem.executeUpdate("INSERT INTO my_user(name,pwd) VALUES('iris','123456')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("SQLException:"+e);
//		}
	}
}

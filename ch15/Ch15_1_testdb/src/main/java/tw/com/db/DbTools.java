package tw.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbTools {
	private static String url = "jdbc:mysql://localhost:3306/testdb20250623?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
	private static String user = "root";
	private static String password = "123456";
	
	public static boolean regisrter(String name,String pwd) {
		String sql = "INSERT INTO my_user(name,pwd) VALUES(?,?)";
		try(Connection conn  =  DriverManager.getConnection(url,user,password);
			PreparedStatement pstem =	conn.prepareStatement(sql);){
			pstem.setString(1, name);
			pstem.setString(2, pwd);
			int count = pstem.executeUpdate();
			return count > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQLException:"+e);
				return false;
			}
	}

	
}

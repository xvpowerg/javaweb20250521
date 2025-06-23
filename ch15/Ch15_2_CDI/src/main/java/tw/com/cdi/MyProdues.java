package tw.com.cdi;

import java.util.ArrayList;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import tw.com.beans.MyApple;

public class MyProdues {	
	
	@Produces
	@Named("redApple")
	private MyApple getReadApple() {
		MyApple myApple = new MyApple();
		myApple.setName("Red Apple");
		myApple.setPrice(100);
		return myApple;
	}
	@Produces
	@Named("appleList")
	private ArrayList<MyApple> getAppleList(){
		ArrayList<MyApple> myAppleList = new ArrayList();
		MyApple a1 = new MyApple();
		MyApple a2 = new MyApple();
		MyApple a3 = new MyApple();
		a1.setName("Apple1");
		a1.setPrice(100);
		a2.setName("Apple2");
		a2.setPrice(101);
		a3.setName("Apple3");
		a3.setPrice(103);
		myAppleList.add(a1);
		myAppleList.add(a2);
		myAppleList.add(a3);
		return myAppleList;
	}
	
	
}

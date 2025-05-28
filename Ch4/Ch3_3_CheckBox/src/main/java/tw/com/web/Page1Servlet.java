package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	
	static String getFoodName(String key) {
		switch(key) {
			case "0":
				return "雞排";
			case "1":
				return "排骨飯";	
			case "2":
				return "魚排";
			default:
				return "查無此物";
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		//String food = req.getParameter("food");
		String[] foods = req.getParameterValues("food");
		//Stream<String> foodStream =  Stream.of(foods);
		//String data = foodStream.collect(Collectors.joining(","));
		//out.println(data);
		//out.println("雞排飯");
		Map<String,String[]> pMap =  req.getParameterMap();
		for (String food : foods) {
			String[] foodData =  food.split("#");
			String price = foodData[0];
			String type =getFoodName(foodData[1]);
			String countKey = "count_"+foodData[1];//1
			
			String countStr = pMap.getOrDefault(countKey,new String[] {"0"})[0];
			out.println(type+":"+price+" count:"+countStr);
		}
		
		
		/*
		pMap.forEach((k,values)->{
			
			out.print("k:"+k);//2
			for (String v : values) {
				out.print(v+" ");
			}
			
			out.println();
		});*/
		
	}
}

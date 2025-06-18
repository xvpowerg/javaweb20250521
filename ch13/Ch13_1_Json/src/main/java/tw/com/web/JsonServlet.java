package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/testJson")
public class JsonServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String json = "{\r\n"
					+ "     \"firstName\": \"John\",\r\n"
					+ "     \"lastName\": \"Smith\",\r\n"
					+ "     \"sex\": \"male\",\r\n"
					+ "     \"age\": 25,\r\n"
					+ "     \"address\": \r\n"
					+ "     {\r\n"
					+ "         \"streetAddress\": \"21 2nd Street\",\r\n"
					+ "         \"city\": \"New York\",\r\n"
					+ "         \"state\": \"NY\",\r\n"
					+ "         \"postalCode\": \"10021\"\r\n"
					+ "     },\r\n"
					+ "     \"phoneNumber\": \r\n"
					+ "     [\r\n"
					+ "         {\r\n"
					+ "           \"type\": \"home\",\r\n"
					+ "           \"number\": \"212 555-1234\"\r\n"
					+ "         },\r\n"
					+ "         {\r\n"
					+ "           \"type\": \"fax\",\r\n"
					+ "           \"number\": \"646 555-4567\"\r\n"
					+ "         }\r\n"
					+ "     ]\r\n"
					+ " }";
			
			System.out.println(json);
			ObjectMapper objMapper = new ObjectMapper();
			Map map =  objMapper.readValue(json, Map.class);
			System.out.println(map);
			String firstName = map.getOrDefault("firstName", "Empty").toString();
			System.out.println(firstName);
			Map addrMap = (Map)map.get("address");
			String city = addrMap.get("city").toString();
			System.out.println(city);
			
			ArrayList<Map<String,Object>> pList =
					(ArrayList<Map<String,Object>>) map.getOrDefault("phoneNumber", new ArrayList());
			
			pList.forEach(pMap->{
				
				System.out.println(pMap.get("type")+":"+pMap.get("number"));
				
			});
		}
}

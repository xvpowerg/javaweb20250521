package tw.com.web;

import java.util.HashMap;
import java.util.Map;

public class MySession  {
	private Map<String,Object> data = new HashMap<>();
	public Object getAttribute(String key) {
		return data.get(key);
	}
	
	public void setAttribute(String key,Object value) {
		data.put(key, value);
	}
}

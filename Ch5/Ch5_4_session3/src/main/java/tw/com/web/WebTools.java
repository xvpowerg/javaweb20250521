package tw.com.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class WebTools {
	private static final Map<String,MySession> 
				myHttpSessionMap = new HashMap<>();
	private static final String MY_HTTP_SESSION_ID = "MY_HTTP_SESSION_ID";
	
	public static MySession getMySession(HttpServletRequest req,HttpServletResponse resp) {
		Cookie[]  cookies =  req.getCookies();
		String mySessionId = "";
		if (cookies != null) {
			Stream<Cookie> cookStream =  Stream.of(cookies);
			Optional<Cookie> opCookie = 
					cookStream.filter(c->c.getName().equals(MY_HTTP_SESSION_ID)).findFirst();
			
			if (opCookie.isPresent()) {
				mySessionId = opCookie.get().getValue();
			}
		}
		MySession session = null;
		if (mySessionId.isEmpty() || 
				!myHttpSessionMap.containsKey(mySessionId) ||
				myHttpSessionMap.get(mySessionId) == null) {
			mySessionId = LocalDateTime.now().toString();
			session = new MySession();
			myHttpSessionMap.put(mySessionId, session);
		}else {
			session = myHttpSessionMap.get(mySessionId);
		}
		
		
		return session;
	}
}

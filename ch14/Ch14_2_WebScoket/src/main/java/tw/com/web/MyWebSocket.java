package tw.com.web;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class MyWebSocket {
	
	@OnMessage
	public String message(String meg) {
		String upMsg = meg.toUpperCase();
		return upMsg;
	}
}

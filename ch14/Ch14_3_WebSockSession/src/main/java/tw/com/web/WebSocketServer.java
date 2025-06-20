package tw.com.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, InterruptedException {
		session.getBasicRemote().sendText("收到的訊息:"+message);
		for (int i = 1; i<= 10; i++) {
			TimeUnit.SECONDS.sleep(1);
			session.getBasicRemote().sendText("Server Send msg "+i+"筆");
		}
		session.getBasicRemote().sendText("完成");
		
	}
}

package tw.com.web;

import java.io.IOException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet extends HttpServlet {
	
	private ExecutorService es;
	@Override
	public void init() throws ServletException {
		es = Executors.newCachedThreadPool();
	}
	
	private int genNumber() {
		System.out.println("Start genNumber:"+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch(Exception ex) {
			
		}
		
		Random ran = new Random();
		System.out.println("End genNumber:"+Thread.currentThread().getName());
		return ran.nextInt();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Start doGet:"+Thread.currentThread().getName());
		AsyncContext ctx =   req.startAsync();
		es.execute(()->{
			int v =  genNumber();
			try {
				ctx.getResponse().getWriter().println(v);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}finally {
				ctx.complete();
			}
		});
		
		System.out.println("End doGet:"+Thread.currentThread().getName());

	}
}

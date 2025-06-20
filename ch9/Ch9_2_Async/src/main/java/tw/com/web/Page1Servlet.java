package tw.com.web;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/page1"} ,asyncSupported=true)
public class Page1Servlet extends HttpServlet{
	private ExecutorService es;
	public void init() {
		es = Executors.newCachedThreadPool();
	}
	
	private String getNumber() {
		System.out.println("getNumber Start....");
		Random ran = new Random();
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch(Exception ex) {
			
		}
		int v = ran.nextInt();
		return v+"";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   AsyncContext ctx =  req.startAsync();
		   System.out.println("Thread Name Start:"+Thread.currentThread().getName());
			es.execute(()->{
				
				String msg = getNumber();
				System.out.println("msg:"+msg);
				
				try {
					ctx.getResponse().getWriter().println("Finish:"+msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}finally {
					ctx.complete();
				}
				
				
			});
			 System.out.println("Thread Name End:"+Thread.currentThread().getName());
	}
	
	
}

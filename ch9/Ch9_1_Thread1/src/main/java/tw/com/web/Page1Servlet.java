package tw.com.web;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	private ExecutorService es;
	public void init() throws ServletException{
		es = Executors.newCachedThreadPool();
	}
	private void test(HttpServletResponse resp) {
		for(int i = 1; i <= 10;i++) {
			System.out.println("工作中...."+i+Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(Exception ex) {
				
			}
		}
		
		try {
			resp.getWriter().println("Finish");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.getWriter().println("Start Page1~");	
		System.out.println("ThreadName Start:"+Thread.currentThread().getName());
		es.execute(()->{
			test(resp);
		});
		
	
		resp.getWriter().println("End Page1~");	
		System.out.println("ThreadName End:"+Thread.currentThread().getName());
	}
}

package tw.com.web;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.com.json.MaskJsonTools;
import tw.com.tools.MaskNetTools;


@WebServlet(urlPatterns="/mask_page",asyncSupported = true)
public class MaskServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MaskServlet:"+Thread.currentThread().getName());
		AsyncContext context =  req.startAsync();
		MaskNetTools.downloadMaskJson(josn->{			
		System.out.println("downloadMaskJson:"+Thread.currentThread().getName());
			try {
				MaskJsonTools.maskJsonToObj(josn, list->{
					ServletRequest newReq = context.getRequest();
					ServletResponse newResp = context.getResponse();
				
					newReq.setAttribute("maskList", list);
			        try {
			        	
			        	newReq.getRequestDispatcher("mask_page.jsp").forward(newReq, newResp);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						context.complete();
					}
				
				});
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
		});
	}
}

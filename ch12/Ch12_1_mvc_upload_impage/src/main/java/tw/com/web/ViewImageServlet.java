package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/view_images")
public class ViewImageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Path imageDir =  Paths.get("C:","upload_images");
		List<String> imageList =   Files.list(imageDir).
		  map(p->p.getFileName().toString()).
		  collect(Collectors.toList());
		//imageList.forEach(p->System.out.println(p));
		PrintWriter  out =  resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		for(String fileName : imageList) {
			out.println("<div>");
			out.println("<img width='30%' height='30%' src='/myimages/"+fileName+"'>");
			out.println("</div>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}

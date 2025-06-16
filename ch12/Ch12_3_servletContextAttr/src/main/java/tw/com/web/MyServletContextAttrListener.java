package tw.com.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttrListener  implements ServletContextAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		String name = scae.getName();
		String value = scae.getValue().toString();
		System.out.println("Add:"+name+":"+value);
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		String name = scae.getName();
		String value = scae.getValue().toString();
		System.out.println("Removed:"+name+":"+value);
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		String name = scae.getName();
		String value = scae.getValue().toString();
		System.out.println("Replaced:"+name+":"+value);
		ServletContext context = scae.getServletContext();
		String newValue = context.getAttribute(name).toString();
		System.out.println("Replaced new Value:"+newValue);
	}
}

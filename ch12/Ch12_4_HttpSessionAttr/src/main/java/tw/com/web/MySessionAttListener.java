package tw.com.web;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
@WebListener
public class MySessionAttListener implements HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		String name = se.getName();
		Object obj =  se.getValue();
		System.out.println("attributeAdded:"+name+":"+obj);
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		String name = se.getName();
		Object obj =  se.getValue();
		System.out.println("attributeReplaced:"+name+":"+obj);
		HttpSession session =  se.getSession();
		Object newObj = session.getAttribute(name);
		System.out.println("attributeReplaced new:"+name+":"+newObj);
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		String name = se.getName();
		Object obj =  se.getValue();
		System.out.println("Removed:"+name+":"+obj);
	}
}

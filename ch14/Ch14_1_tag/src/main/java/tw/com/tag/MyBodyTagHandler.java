package tw.com.tag;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.BodyContent;
import jakarta.servlet.jsp.tagext.BodyTag;
import jakarta.servlet.jsp.tagext.Tag;

public class MyBodyTagHandler implements BodyTag {
	
	private PageContext pageContext;
	private Tag parent;
	private String message;
	private int count = 1;
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if (count > 3) {
			return SKIP_BODY;
		}
		
		
		
		JspWriter out = this.pageContext.getOut();
		try {
			out.print(String.format("<h1>%d body</h1>", count));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
		
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = this.pageContext.getOut();
		try {
			out.print(String.format("<h1>%s標籤結束</h1>", this.getMessage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = this.pageContext.getOut();
		try {
			out.print(String.format("<h1>%s標籤開始</h1>", this.getMessage()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		this.pageContext = arg0;
	}

	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub
		this.parent = arg0;
	}

	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBodyContent(BodyContent arg0) {
		// TODO Auto-generated method stub
		
	}

}

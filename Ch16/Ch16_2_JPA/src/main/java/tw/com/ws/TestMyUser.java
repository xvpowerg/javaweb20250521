package tw.com.ws;

import jakarta.ejb.EJB;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@Path("myuser")
@Produces(MediaType.APPLICATION_JSON)
public class TestMyUser {
		@EJB
		private MyUserBeanLocal myUserBean;
		
		public class Msg{
			private String msg;

			public String getMsg() {
				return msg;
			}

			public void setMsg(String msg) {
				this.msg = msg;
			}
			
			
		}

@POST		
public Response register(@FormParam("account") String account,
						@FormParam("password") String password) {
	MyUser myuser = new MyUser();
	myuser.setAccount(account);
	myuser.setPassword(password);
	boolean pass = myUserBean.regisrter(myuser);
	if (pass) {
		return Response.ok().encoding("UTF-8").entity(myuser).build();
	}
	Msg msg = new Msg();
	msg.setMsg("fail");
	return Response.status(400).entity(msg).build();
	
}
		
		
}

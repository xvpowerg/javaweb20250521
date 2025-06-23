package tw.com.ws;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Produces(MediaType.APPLICATION_JSON)
@Path("test")
public class TestResful {
	@GET
	public String testHello() {
		return "{\"name\":\"Hello\"}";
	}
	
	@POST
	public String testPost(@FormParam("name") String name,@FormParam("pass") String pass) {
		
		return String.format( "{\"name\":\"%s\",\"pass\":\"%s\"}", name,pass);
	}
	
	@GET
	@Path("/id/{myId:\\S+}")
	public String createUser(@PathParam("myId") String id) {
		return String.format("{\"id\":\"%s\"}", id);
	}
	
	
	
}

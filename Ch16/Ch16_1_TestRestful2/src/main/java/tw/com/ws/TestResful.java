package tw.com.ws;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResful {
	@DELETE
	public String delete(@QueryParam("id") Long id) {
		
		return String.format("{\"id\":\"%d\"}", id);
	}
	
	
	@PATCH
	public String patch(@QueryParam("id") Long id,
			@DefaultValue("empty") @QueryParam("name") String name,
			@DefaultValue("-1") @QueryParam("age")int age) {
	
		return String.format("{\"id\":\"%d\",\"name\":\"%s\",\"age\":\"%d\"}", id,name,age) ;
	}
	
}

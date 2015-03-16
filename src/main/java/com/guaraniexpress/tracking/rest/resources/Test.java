package com.guaraniexpress.tracking.rest.resources;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("regards")
@Produces("application/json;charset=UTF-8")
public class Test {

		@GET
		@Path("hello")	
	public String sayHello(
			@QueryParam("name") @NotNull(message = "Name is required argurment!") String name) {
		return "Hello "
				+ name
				+ ", welcome to the first version of Guaraní Express Tracking RESTful API!!!";
	}
}

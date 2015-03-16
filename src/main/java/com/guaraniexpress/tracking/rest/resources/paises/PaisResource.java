package com.guaraniexpress.tracking.rest.resources.paises;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.guaraniexpress.tracking.boundary.PaisService;
import com.guaraniexpress.tracking.entities.Pais;

@Path("paises")
@Produces("application/json;charset=UTF-8")
public class PaisResource {
	
	@Inject
	private PaisService ps;
	
	@GET
	public Response findAll() {
		List<Pais> resultList =
				ps.list();
		
		return Response.ok(resultList).build();
	}
	
	@GET
	@Path("{idPais}")
	public Response find(@PathParam("idPais") @NotNull(message="Identifier is required") Integer idPais) {
		return Response.ok(ps.get(idPais)).build();
	}
}

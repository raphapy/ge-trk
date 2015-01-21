package com.guaraniexpress.tracking.rest.resources.paises;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.guaraniexpress.tracking.boundary.PaisService;
import com.guaraniexpress.tracking.entities.Pais;

@Path("paises")
@Produces(MediaType.APPLICATION_XML)
public class PaisResource {
	
	@Inject
	private PaisService ps;
	
	@GET
	public List<Pais> findAll() {
		List<Pais> resultList =
				ps.findAll();
		
		return resultList;
	}
	
	@GET
	@Path("{idPais}")
	public Pais find(@PathParam("idPais") @NotNull(message="Identifier is required") Integer idPais) {
		return ps.find(idPais);
	}
}

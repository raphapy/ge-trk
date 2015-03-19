package com.guaraniexpress.tracking.web.resources.globals;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.guaraniexpress.tracking.boundary.globals.CiudadService;
import com.guaraniexpress.tracking.entity.globals.Ciudad;
import com.guaraniexpress.tracking.web.WritableResource;


@Path("paises/localidades/ciudades")
public class CiudadResource extends WritableResource<Ciudad, Short, CiudadService>{
	
	@Inject
	private CiudadService ciudadService;
	
	@Override
	protected CiudadService getDelegatedDao() {
		return this.ciudadService;
	}

	@Override
	protected Class<Ciudad> getEntityBeanType() {
		return Ciudad.class;
	}

	@Override
	protected Class<Short> getEntityKeyType() {
		return Short.class;
	}

}

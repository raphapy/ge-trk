package com.guaraniexpress.tracking.web.resources.globals;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.guaraniexpress.tracking.boundary.globals.PaisService;
import com.guaraniexpress.tracking.entity.globals.Pais;
import com.guaraniexpress.tracking.web.WritableResource;

@Path("paises")
public class PaisResource extends WritableResource<Pais, Short, PaisService> {

	@Inject
	private PaisService ps;

	@Override
	protected PaisService getDelegatedDao() {
		return this.ps;
	}

	@Override
	protected Class<Pais> getEntityBeanType() {
		return Pais.class;
	}

	@Override
	protected Class<Short> getEntityKeyType() {
		return Short.class;
	}
}

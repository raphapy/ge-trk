package com.guaraniexpress.tracking.web.resources.main;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.guaraniexpress.tracking.boundary.main.PaqueteService;
import com.guaraniexpress.tracking.entities.main.Paquete;
import com.guaraniexpress.tracking.web.ReadableResource;

@Path("paquetes")
public class PaqueteResource extends
		ReadableResource<Paquete, Integer, PaqueteService> {

	@Inject
	private PaqueteService paqueteService;

	@Override
	protected PaqueteService getDelegatedDao() {
		return this.paqueteService;
	}

	@Override
	protected Class<Paquete> getEntityBeanType() {
		return Paquete.class;
	}

	@Override
	protected Class<Integer> getEntityKeyType() {
		return Integer.class;
	}

}

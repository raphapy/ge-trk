package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.Ciudad;

@Stateless
public class CiudadService extends GuaraniExpressDao<Ciudad, Short>{

	public CiudadService() {
		super(Ciudad.class);
	}

}

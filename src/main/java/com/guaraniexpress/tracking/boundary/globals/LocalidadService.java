package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.globals.Localidad;

@Stateless
public class LocalidadService extends GuaraniExpressDao<Localidad, Short> {

	public LocalidadService(	) {
		super(Localidad.class);
	}
}

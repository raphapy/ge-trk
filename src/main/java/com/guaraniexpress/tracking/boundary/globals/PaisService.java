package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.Pais;

@Stateless
public class PaisService extends GuaraniExpressDao<Pais, Integer> {

	@Override
	protected Class<Pais> getEntityBeanType() {
		return Pais.class;
	}
}
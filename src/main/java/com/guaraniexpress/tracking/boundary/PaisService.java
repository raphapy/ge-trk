package com.guaraniexpress.tracking.boundary;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDAO;
import com.guaraniexpress.tracking.entities.Pais;

@Stateless
public class PaisService extends GuaraniExpressDAO<Pais, Integer> {

	@Override
	protected Class<Pais> getEntityBeanType() {
		return Pais.class;
	}
}

package com.guaraniexpress.tracking.boundary.globals;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.globals.Pais;

import javax.ejb.Stateless;

@Stateless
public class PaisService extends GuaraniExpressDao<Pais, Short>{

	public PaisService() {
		super(Pais.class);
	}

}

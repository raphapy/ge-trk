package com.guaraniexpress.tracking.boundary.main;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.main.Paquete;

public class PaqueteService extends GuaraniExpressDao<Paquete, Integer> {

	public PaqueteService() {
		super(Paquete.class);
	}

}

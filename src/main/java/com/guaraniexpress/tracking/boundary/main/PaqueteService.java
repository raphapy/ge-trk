package com.guaraniexpress.tracking.boundary.main;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.main.Paquete;

public class PaqueteService extends GuaraniExpressDao<Paquete, Integer> {

	public PaqueteService() {
		super(Paquete.class);
	}

}

package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.globals.Lenguaje;

@Stateless
public class LenguajeService extends GuaraniExpressDao<Lenguaje, Integer>{

	public LenguajeService() {
		super(Lenguaje.class);
	}
}

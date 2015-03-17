package com.guaraniexpress.tracking.boundary.globals;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.Persona;

public class PersonaService extends GuaraniExpressDao<Persona, Integer>{

	@Override
	protected Class<Persona> getEntityBeanType() {
		return Persona.class;
	}

}

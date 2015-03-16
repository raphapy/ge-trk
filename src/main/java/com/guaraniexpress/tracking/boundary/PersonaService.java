package com.guaraniexpress.tracking.boundary;

import com.guaraniexpress.tracking.dao.GuaraniExpressDAO;
import com.guaraniexpress.tracking.entities.Persona;

public class PersonaService extends GuaraniExpressDAO<Persona, Integer>{

	@Override
	protected Class<Persona> getEntityBeanType() {
		return Persona.class;
	}

}

package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.globals.Persona;

@Stateless
public class PersonaService extends GuaraniExpressDao<Persona, Integer> {

	public PersonaService() {
		super(Persona.class);
		}
}

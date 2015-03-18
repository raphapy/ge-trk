package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.InformacionContactoPersona;

@Stateless
public class InformacionContactoPersonaService extends
		GuaraniExpressDao<InformacionContactoPersona, Integer> {

	public InformacionContactoPersonaService() {
		super(InformacionContactoPersona.class);
	}
}

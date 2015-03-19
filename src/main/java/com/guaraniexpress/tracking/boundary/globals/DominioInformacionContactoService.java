package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.globals.DominioInformacionContacto;

@Stateless
public class DominioInformacionContactoService extends
		GuaraniExpressDao<DominioInformacionContacto, Integer> {

	public DominioInformacionContactoService() {
		super(DominioInformacionContacto.class);
	}
}

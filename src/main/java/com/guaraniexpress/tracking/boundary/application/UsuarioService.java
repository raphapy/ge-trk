package com.guaraniexpress.tracking.boundary.application;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.application.Usuario;

public class UsuarioService extends GuaraniExpressDao<Usuario, Integer> {
	public UsuarioService() {
		super(Usuario.class);
	}
}

package com.guaraniexpress.tracking.boundary.application;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entity.application.Usuario;

@Stateless
public class UsuarioService extends GuaraniExpressDao<Usuario, Integer> {
	public UsuarioService() {
		super(Usuario.class);
	}
}

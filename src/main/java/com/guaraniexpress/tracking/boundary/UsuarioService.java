package com.guaraniexpress.tracking.boundary;

import com.guaraniexpress.tracking.dao.GuaraniExpressDAO;
import com.guaraniexpress.tracking.entities.Usuario;

public class UsuarioService extends GuaraniExpressDAO<Usuario, Integer>{

	@Override
	protected Class<Usuario> getEntityBeanType() {
		return Usuario.class;
	}

}

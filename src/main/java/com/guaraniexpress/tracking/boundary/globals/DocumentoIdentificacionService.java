package com.guaraniexpress.tracking.boundary.globals;

import javax.ejb.Stateless;

import com.guaraniexpress.tracking.dao.GuaraniExpressDao;
import com.guaraniexpress.tracking.entities.globals.DocumentoIdentificacion;

@Stateless
public class DocumentoIdentificacionService extends
		GuaraniExpressDao<DocumentoIdentificacion, Short> {

	public DocumentoIdentificacionService() {
		super(DocumentoIdentificacion.class);
	}

}

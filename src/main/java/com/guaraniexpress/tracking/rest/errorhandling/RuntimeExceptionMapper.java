package com.guaraniexpress.tracking.rest.errorhandling;

import static com.guaraniexpress.tracking.rest.errorhandling.Error.build;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 
 * @author Ruben Lopez
 * 
 */
@Provider
public class RuntimeExceptionMapper implements
		ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException e) {
		if (e instanceof IllegalStateException) {
			return build(500, "Error interno del servidor.", e.getMessage());
		} else {
			return build(500, "Error interno del servidor.", e.getMessage());
		}
	}

}
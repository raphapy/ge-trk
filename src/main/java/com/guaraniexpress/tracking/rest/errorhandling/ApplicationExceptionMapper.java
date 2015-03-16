package com.guaraniexpress.tracking.rest.errorhandling;

import static com.guaraniexpress.tracking.rest.errorhandling.Error.build;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.guaraniexpress.tracking.exceptions.ApplicationException;


/**
 * 
 * @author Ruben Lopez
 *
 */

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

	@Override
	public Response toResponse(ApplicationException e) {
		if (e instanceof ApplicationException.IllegalArgument) {
			return build(400,"Argumento inválido.", e.getMessage());
		} else if (e instanceof ApplicationException.NotFound) {
			return build(404, "No encontrado.", e.getMessage());
		} else {
			return build(500, "Error interno del servidor.", e.getMessage());
		}
	}

}

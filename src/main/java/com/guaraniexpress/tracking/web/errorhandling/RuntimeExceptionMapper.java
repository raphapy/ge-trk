package com.guaraniexpress.tracking.web.errorhandling;

import static com.guaraniexpress.tracking.web.errorhandling.Error.build;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.guaraniexpress.tracking.i18n.Messages;

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
			return build(500, Messages.getString("ExceptionMapper.INTERNAL_SERVER_ERROR_MESSAGE"), e.getMessage());
		} else {
			return build(500, Messages.getString("ExceptionMapper.INTERNAL_SERVER_ERROR_MESSAGE"), e.getMessage()); //$NON-NLS-1$
		}
	}

}
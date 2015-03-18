package com.guaraniexpress.tracking.web.errorhandling;

import static com.guaraniexpress.tracking.web.errorhandling.Error.build;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.guaraniexpress.tracking.exceptions.ApplicationException;
import com.guaraniexpress.tracking.i18n.Messages;


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
			return build(400,Messages.getString("ExceptionMapper.INVALID_ARGUMENT_MESSAGE"), e.getMessage()); //$NON-NLS-1$
		} else if (e instanceof ApplicationException.NotFound) {
			return build(404, Messages.getString("ExceptionMapper.NOT_FOUND_MESSAGE"), e.getMessage()); //$NON-NLS-1$
		} else {
			return build(500, Messages.getString("ExceptionMapper.INTERNAL_SERVER_ERROR_MESSAGE"), e.getMessage()); //$NON-NLS-1$
		}
	}

}

package com.guaraniexpress.tracking.rest.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.guaraniexpress.tracking.exceptions.BusinessException;

@Provider
public class BusinessExceptionMapper implements
		ExceptionMapper<BusinessException> {

	@Override
	public Response toResponse(BusinessException e) {
		if (e instanceof BusinessException.ModelValidationException) {

			return Error.build(Status.NOT_ACCEPTABLE.getStatusCode(), e
					.getMessage(),
					((BusinessException.ModelValidationException) e)
							.getViolationMessages());

		} else {

			return Error.build(Status.NOT_ACCEPTABLE.getStatusCode(),
					"Regla de negocio violada", e.getMessage());

		}
	}

}
package com.guaraniexpress.tracking.web.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.guaraniexpress.tracking.exceptions.BusinessException;
import com.guaraniexpress.tracking.i18n.Messages;

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
					Messages.getString("ExceptionMapper.BUSINESS_RULE_VIOLATED_MESSAGE"), e.getMessage()); //$NON-NLS-1$

		}
	}

}
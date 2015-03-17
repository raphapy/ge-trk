package com.guaraniexpress.tracking.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.guaraniexpress.tracking.exceptions.BusinessException;
import com.guaraniexpress.tracking.i18n.Messages;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class BeanValidationService {

	@Inject
	private Validator validator;

	public <T> T validate(T object) throws BusinessException,
			IllegalArgumentException {
		if (object == null) {
			throw new IllegalArgumentException(
					Messages.getString("BeanValidationService.OBJECT_TO_VALIDATE_NOT_NULL_MESSAGE")); //$NON-NLS-1$
		}

		Set<ConstraintViolation<T>> violations = validator.validate(object);

		// Si no existen violaciones se retorna el objeto
		if (violations != null && violations.size() == 0) {
			return object;
		} else {
			List<String> messages = extractMessagesList(violations);
			throw new BusinessException.ModelValidationException(
					Messages.getString("BeanValidationService.ERRORS_DURING_OBJECT_VALIDATION_MESSAGE") //$NON-NLS-1$
							+ object.getClass().getSimpleName(), messages);
		}
	}

	public <T> T validate(T object, Class<?>... groups)
			throws BusinessException, IllegalArgumentException {

		if (object == null) {
			throw new IllegalArgumentException(
					Messages.getString("BeanValidationService.OBJECT_TO_VALIDATE_NOT_NULL_MESSAGE")); //$NON-NLS-1$
		}

		Set<ConstraintViolation<T>> violations = validator.validate(object,
				groups);

		// Si no existen violaciones se retorna el objeto
		if (violations != null && violations.size() == 0) {
			return object;
		} else {
			List<String> messages = extractMessagesList(violations);
			throw new BusinessException.ModelValidationException(
					Messages.getString("BeanValidationService.ERRORS_DURING_OBJECT_VALIDATION_MESSAGE") //$NON-NLS-1$
							+ object.getClass().getSimpleName(), messages);
		}
	}

	private <T> List<String> extractMessagesList(
			Set<ConstraintViolation<T>> violations)
			throws IllegalArgumentException {
		if (violations == null) {
			throw new IllegalArgumentException(
					Messages.getString("BeanValidationService.VIOLATION_SET_NOT_NULL_MESSAGE")); //$NON-NLS-1$
		}

		List<String> messages = new ArrayList<String>();
		for (ConstraintViolation<T> constraintViolation : violations) {
			messages.add(constraintViolation.getMessage());
		}

		return messages;
	}
}

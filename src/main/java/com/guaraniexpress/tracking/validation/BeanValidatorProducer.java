package com.guaraniexpress.tracking.validation;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Singleton
public class BeanValidatorProducer {
	
	@Inject
	private ValidatorFactory factory;
	
	
	@Produces
    public Validator getValidator() {
		return factory.getValidator();
	}
}

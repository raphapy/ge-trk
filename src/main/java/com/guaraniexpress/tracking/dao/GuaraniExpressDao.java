package com.guaraniexpress.tracking.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.guaraniexpress.tracking.resources.GuaraniExpressPersistence;

public abstract class GuaraniExpressDao<T, ID extends Serializable> extends
		AbstractDao<T, Serializable> {

	public GuaraniExpressDao(Class<T> entityClass) {
		super(entityClass);
	}

	@Inject
	@GuaraniExpressPersistence
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}

package com.guaraniexpress.tracking.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.guaraniexpress.tracking.resources.GuaraniExpressPersistence;

public abstract class GuaraniExpressDAO<T, ID extends Serializable> extends
		AbstractGenericDAO<T, Serializable> {

	@Inject
	@GuaraniExpressPersistence
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}

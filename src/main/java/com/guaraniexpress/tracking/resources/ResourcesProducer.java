package com.guaraniexpress.tracking.resources;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ResourcesProducer {

	@PersistenceContext(name = "GETrackingPU")
	private EntityManager guaraniExpressEntityManager;

	@Produces
	@GuaraniExpressPersistence
	public EntityManager obtainGuaraniExpressEntityManager() {
		return this.guaraniExpressEntityManager;
	}
}

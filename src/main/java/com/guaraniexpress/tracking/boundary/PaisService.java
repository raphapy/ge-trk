package com.guaraniexpress.tracking.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.guaraniexpress.tracking.entities.Pais;

@Stateless
public class PaisService {

	@Inject
	private EntityManager em;
	
	public List<Pais> findAll() {
		Query q = em.createNamedQuery("Pais.findAll", Pais.class);
		@SuppressWarnings("unchecked")
		List<Pais> resultList = (List<Pais>)q.getResultList();
		return resultList;
	}
	
	public Pais find(Integer idPais) {
		return em.find(Pais.class, idPais);
	}
}

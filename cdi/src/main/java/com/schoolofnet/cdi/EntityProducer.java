package com.schoolofnet.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Log
public class EntityProducer {
	
	@ApplicationScoped
	@Produces
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("Unit").createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
}

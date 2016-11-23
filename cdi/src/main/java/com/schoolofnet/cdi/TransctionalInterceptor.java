package com.schoolofnet.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transctional
public class TransctionalInterceptor {

	@Inject
	private EntityManager em;
	
	@AroundInvoke
	public Object intercept(InvocationContext context) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		
		Object result = null;
		
		try {
			result = context.proceed();
		} catch(Exception e) {
			e.getMessage();
		}
		
		em.getTransaction().commit();
		
		return result;
	}
}

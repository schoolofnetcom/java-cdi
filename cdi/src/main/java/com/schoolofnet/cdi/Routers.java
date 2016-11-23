package com.schoolofnet.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class Routers {

	@Inject
	@Route
	private Instance<Object> routes;
	
	@PostConstruct
	public void init() {
		routes.forEach((route) -> {
			
		});
	}
}

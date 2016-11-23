package com.schoolofnet.routers;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.schoolofnet.cdi.Route;
import com.schoolofnet.services.PersonService;

import static spark.Spark.get;

@Route
public class PersonRouter {

	@Inject
	private PersonService personService;
	
	@PostConstruct
	public void init() {
		get("/", "application/json", (req, res) -> {
			return personService.findAll(req, res);
		});
		get("/create", "application/json", (req, res) -> {
			return personService.create(req, res);
		});		
	}
}

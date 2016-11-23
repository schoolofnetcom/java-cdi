package com.schoolofnet.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.schoolofnet.cdi.Transctional;
import com.schoolofnet.entity.Person;

import spark.Request;
import spark.Response;

public class PersonService {

	@Inject
	private EntityManager em;
	
	private JsonObject jsonObject = new JsonObject();
	
	public JsonObject findAll(Request req, Response res) {
		List<Person> list = em.createNativeQuery("SELECT * FROM person").getResultList();
		
		Gson gson = new GsonBuilder().create();
		
		jsonObject.addProperty("data", gson.toJson(list));
		
		return jsonObject;
	}
	
	@Transctional
	public JsonObject create(Request req, Response res) {
		Person p = new Person();
		
		p.setName("Wesley");
		
		em.persist(p);
		
		jsonObject.addProperty("data", new Gson().toJson(p));
		
		return jsonObject;
	}
}

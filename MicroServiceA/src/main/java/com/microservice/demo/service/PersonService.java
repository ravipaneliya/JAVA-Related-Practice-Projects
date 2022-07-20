package com.microservice.demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.microservice.demo.entity.PersonEntity;
import com.microservice.demo.entity.Response;
import com.microservice.demo.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repo;
	private RestTemplate template = new RestTemplate();

	public PersonEntity addPerson(PersonEntity person) {
		return repo.save(person);
	}

	public Response getPersonWithHobby(int personId) {

		final String url = "http://localhost:8082/hobby/{personId}";
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("personId", personId);
		String hobby = null;

		try {
			hobby = template.getForObject(url, String.class, map);
		} catch (HttpClientErrorException e) {
			System.out.println("Hobby Not Found Exception : " + e.getMessage());
		}

		PersonEntity entity = repo.findById(personId).get();
		Response resp = new Response();
		resp.setEntity(entity);
		resp.setHobby(hobby);

		return resp;

	}
}

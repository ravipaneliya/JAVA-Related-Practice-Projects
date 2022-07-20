package com.microservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.demo.entity.HobbyEntity;
import com.microservice.demo.repo.HobbyRepository;

@Service
public class HobbyService {

	@Autowired
	HobbyRepository repo;
	
	public HobbyEntity saveHobby(HobbyEntity hobby) {
		return repo.save(hobby);
	}
	
	public String findByPersonId(int personId) {
		return repo.findByPersonId(personId);
	}
}

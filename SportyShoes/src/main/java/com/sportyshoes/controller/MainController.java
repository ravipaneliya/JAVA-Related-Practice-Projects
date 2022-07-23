package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sportyshoes.model.User;
import com.sportyshoes.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String showWelcome(){
		return "Welcome to Sporty Shoes APIs.";
	}
	
	@GetMapping("/admin")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		User addedUser = userService.addUser(user);
		
		if(addedUser!=null)
			return new ResponseEntity<Object>(addedUser,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while add user", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

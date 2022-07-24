package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Category;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.User;
import com.sportyshoes.service.CategoryService;
import com.sportyshoes.service.ProductService;
import com.sportyshoes.service.UserService;

@RestController
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService prodService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public String showWelcome() {
		return "Welcome to Sporty Shoes APIs.";
	}

	@GetMapping("/admin")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<Object> getUser(@PathVariable int id) {
		User user = userService.getUserById(id);

		if (user != null)
			return new ResponseEntity<Object>(user, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("User is not available with given id", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/admin/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User user) {
		User updatedUser = userService.updateUser(user, id);

		if (updatedUser != null)
			return new ResponseEntity<Object>(updatedUser, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Updated Operation Failed..", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/admin")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		System.out.println("\n\n-------------------- POST CALL RECEIVED...");
		User addedUser = userService.addUser(user);

		if (addedUser != null)
			return new ResponseEntity<Object>(addedUser, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while adding user", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/admin/product")
	public List<Product> getAllProducts() {
		return prodService.getAllProducts();
	}

	@GetMapping("/admin/product/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable int id) {
		Product prod = prodService.getProductById(id);
		if (prod != null)
			return new ResponseEntity<Object>(prod, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Product is not available with given id", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/admin/product")
	public ResponseEntity<Object> addProduct(@RequestBody Product prod) {
		Category cat = prod.getCategory();
		if (cat != null && cat.getId() == 0) {
			cat = new Category(cat.getName(), cat.getType());
			cat = categoryService.addCategory(cat);
		}
		prod = new Product(prod.getName(), prod.getDescription(), prod.getPrice(), cat);
		
		Product newProd = prodService.addProduct(prod);
		if (newProd != null)
			return new ResponseEntity<Object>(newProd, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Error while adding Product", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/admin/product/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product prod, @PathVariable int id) {
		Product updatedProd = prodService.updateProduct(prod, id);
		if (updatedProd != null)
			return new ResponseEntity<Object>(updatedProd, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Product is not available with given id", HttpStatus.NOT_FOUND);
	}
}

package com.sportyshoes.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Category;
import com.sportyshoes.model.Product;
import com.sportyshoes.model.Purchase;
import com.sportyshoes.model.User;
import com.sportyshoes.service.CategoryService;
import com.sportyshoes.service.ProductService;
import com.sportyshoes.service.PurchaseService;
import com.sportyshoes.service.UserService;

@RestController
public class MainController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService prodService;

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PurchaseService purService;

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
		User addedUser = userService.addUser(user);

		if (addedUser != null)
			return new ResponseEntity<Object>(addedUser, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while adding user", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		if(userService.deleteUser(id))
			return new ResponseEntity<Object>("User Is Successfully Deleted", HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("User is not available with given id : " + id, HttpStatus.NOT_FOUND);
	}
	
	//Product Mappings Starts From Here...
	
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
		Category newCategory = prod.getCategory();
		if(newCategory != null) {
			Category category = categoryService.getCategoryById(newCategory.getId());
			if (category == null || category.getId() == 0) {
				newCategory = new Category(newCategory.getName(), newCategory.getType());
				newCategory = categoryService.addCategory(newCategory);
			} else {
				newCategory = category;
			}
		}
		prod = new Product(prod.getName(), prod.getDescription(), prod.getPrice(), newCategory);
		
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
	
	@DeleteMapping("/admin/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		if(prodService.deleteProduct(id))
			return new ResponseEntity<Object>("Product Is Successfully Deleted", HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Product is not available with given id : " + id, HttpStatus.NOT_FOUND);
	}
	
	//Purchase Mappings Starts From Here...
	
	@PostMapping("/admin/purchase")
	public ResponseEntity<Object> addPurchase(@RequestBody Purchase pur){
		Set<Product> prods = new HashSet<Product>();
		for(Product prod : pur.getProducts()){
			prods.add(prodService.getProductById(prod.getId()));
		}
		
		User user = userService.getUserById(pur.getUser().getId());
		
		pur = new Purchase(prods, user, pur.getOrderDate());
		Purchase newPur = purService.addPurchase(pur);
		if (newPur != null)
			return new ResponseEntity<Object>(newPur, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Error while adding Purchase", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/admin/purchase/{id}")
	public ResponseEntity<Object> getPurchase(@PathVariable int id) {
		Purchase pur = purService.getPurchaseById(id);
		if (pur != null)
			return new ResponseEntity<Object>(pur, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Purchase is not available with given order id", HttpStatus.NOT_FOUND);
	}
}

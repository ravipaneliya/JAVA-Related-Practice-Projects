package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Product;
import com.sportyshoes.model.Purchase;
import com.sportyshoes.repo.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository purRepo;
	
	public Purchase addPurchase(Purchase pur) {
		return purRepo.save(pur);
	}
	
	public Purchase getPurchaseById(int id) {
		if (purRepo.findById(id).isPresent())
			return purRepo.findById(id).get();
		else
			return null;
	}
	
	public List<Purchase> getAllPurchase(){
		return purRepo.findAll();
	}
	
	public List<Purchase> getPurchasesByDate(Date orderDate){
		return purRepo.getPurchasesByOrderDate(orderDate);
	}
	
	public List<Purchase> getPurchasesByCategory(String categoryName){
		List<Purchase> catPurchases = new ArrayList<>();
		for(Purchase pur : getAllPurchase()) {
			for(Product prod : pur.getProducts()) {
				if(prod.getCategory().getName().equalsIgnoreCase(categoryName)) {
					catPurchases.add(pur);
				}
			}
		}
		return catPurchases;
	}
}

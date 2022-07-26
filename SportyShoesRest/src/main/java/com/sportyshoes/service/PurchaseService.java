package com.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}

package com.sportyshoes.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sportyshoes.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	@Query("select p from purchases p where date(p.orderDate) = date(:orderDate)")
	List<Purchase> getPurchasesByOrderDate(Date orderDate);
}

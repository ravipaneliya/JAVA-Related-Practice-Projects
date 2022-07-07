package com.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerce.dao.EProductDao;
import com.ecommerce.entity.EProductEntity;

@Controller
public class MainController {

	@Autowired
	EProductDao dao;
	
	@GetMapping("/listproducts")
	public String getAllProducts(ModelMap map) {
		
		List<EProductEntity> list= dao.getAllProducts();
		map.addAttribute("list",list);
		return "products";
	}
	
	@GetMapping("/updaterecord")
	public String getAllProducts(HttpServletRequest req, ModelMap mp) {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String da = req.getParameter("da");
		
		dao.updateProduct(id, name, price, da);
		
		List<EProductEntity> list= dao.getAllProducts();
		mp.addAttribute("list",list);
		return "products";
	}
}

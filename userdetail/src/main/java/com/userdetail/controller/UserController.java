package com.userdetail.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.userdetail.dao.UsersDao;
import com.userdetail.model.User;
import com.userdetail.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getuser")
	public String getUser(HttpServletRequest req, ModelMap mp) {
		int id = Integer.parseInt(req.getParameter("id"));
		mp.put("user", new User());
		mp.put("userdetail", userService.getUser(id));
		return "userdetails";
	}
}

package com.userdetail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.userdetail.dao.UserDao;
import com.userdetail.entity.UserEntity;

@Controller
public class MainController {

	@Autowired
	UserDao dao;
	
	@GetMapping("/getuser")
	public String getUser(HttpServletRequest req,ModelMap map) {
		int id = Integer.parseInt(req.getParameter("userid"));
		List<UserEntity> list= dao.getUser(id);
		if(list.size() > 0) {
			map.addAttribute("list",list);
			return "userdetails";
		} else {
			return "searchresult";
		}
	}
	
	@GetMapping("/updaterecord")
	public String updateUser(HttpServletRequest req, ModelMap mp) {
		int id = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		
		mp.addAttribute("result",dao.updateUser(id, name, city));
		return "updateresult";
	}
}

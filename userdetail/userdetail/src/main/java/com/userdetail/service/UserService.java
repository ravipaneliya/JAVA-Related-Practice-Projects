package com.userdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userdetail.dao.UsersDao;
import com.userdetail.model.User;

@Service
public class UserService {
	
	@Autowired
	private UsersDao userDao;
	
	public User getUser(int id){
		return userDao.getUser(id);
	}
}

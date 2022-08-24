package com.userdetail.dao;

import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.userdetail.model.User;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUser(int userid) {
//		String hql = "FROM users U WHERE id = " + userid + "";
//		Query query = sessionFactory.openSession().createQuery(hql);
//		return (User) query.list();
		return new User();
	}
	
	public void updateUser() {
		/*
		 String hql = "UPDATE Employee set salary = :salary "  + 
             "WHERE id = :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("salary", 1000);
		query.setParameter("employee_id", 10);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
		 */
	}
}

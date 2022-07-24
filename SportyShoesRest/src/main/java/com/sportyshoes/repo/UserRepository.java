package com.sportyshoes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sportyshoes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

//	@Query("FROM users WHERE name=?1 and password = ?2") 
//	public User getUserByUsernameAndPaswordAndRole(String name, String password);
}

package com.restdemo.practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restdemo.practice.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}

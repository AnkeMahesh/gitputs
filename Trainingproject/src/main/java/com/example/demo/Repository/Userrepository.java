package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface Userrepository extends JpaRepository<User, String>{

User findByIdAndPassword(String id,String password);
	

}

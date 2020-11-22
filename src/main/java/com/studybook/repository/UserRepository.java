package com.studybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studybook.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
}

package com.expenseApp.expenseApiTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseApp.expenseApiTracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User>findByEmail(String email);
//	
//    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String email);
//
//    Optional<User> findByUsername(String name);
//
//    Boolean existsByUsername(String name);
	
	Boolean existsByEmail(String email);

}

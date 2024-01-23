package com.expenseApp.expenseApiTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseApp.expenseApiTracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

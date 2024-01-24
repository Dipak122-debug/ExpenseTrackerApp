package com.expenseApp.expenseApiTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;
import com.expenseApp.expenseApiTracker.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
}

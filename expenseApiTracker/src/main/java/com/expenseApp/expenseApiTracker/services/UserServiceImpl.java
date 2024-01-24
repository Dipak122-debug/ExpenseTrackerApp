package com.expenseApp.expenseApiTracker.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;
import com.expenseApp.expenseApiTracker.exceptions.ItemAlreadyExistsException;
import com.expenseApp.expenseApiTracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered with email: "+user.getEmail());
		}
		User newUser =  new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}
}

package com.expenseApp.expenseApiTracker.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;
import com.expenseApp.expenseApiTracker.exceptions.ItemAlreadyExistsException;
import com.expenseApp.expenseApiTracker.exceptions.ResourceNotFoundException;
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
	
	@Override
	public User readUser(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: "+id));
	}
	
	@Override
	public User updateUser(UserModel user, Long id) {
		
		 User existingUser = readUser(id);
		 existingUser.setName(user.getName()!=null ? user.getName() : existingUser.getName());
		 existingUser.setEmail(user.getEmail()!=null ? user.getEmail() : existingUser.getEmail());
		 existingUser.setPassword(user.getPassword()!=null ? user.getPassword() : existingUser.getPassword());
		 existingUser.setAge(user.getAge()!=null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}
	
	@Override
	public void deleteUser(Long id) {
		User existingUser = readUser(id);
		userRepository.delete(existingUser);
	}
}

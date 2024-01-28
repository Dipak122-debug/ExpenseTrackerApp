package com.expenseApp.expenseApiTracker.services;

import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);
	
	User readUser(Long id);
	
	User updateUser(UserModel user, Long id);
	
	void deleteUser(Long id);

}

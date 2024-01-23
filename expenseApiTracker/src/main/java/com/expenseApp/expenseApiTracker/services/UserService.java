package com.expenseApp.expenseApiTracker.services;

import com.expenseApp.expenseApiTracker.entity.User;
import com.expenseApp.expenseApiTracker.entity.UserModel;

public interface UserService {
	
	User createUser(UserModel user);

}

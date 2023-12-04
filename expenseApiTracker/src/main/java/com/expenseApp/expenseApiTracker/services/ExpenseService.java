package com.expenseApp.expenseApiTracker.services;

import java.util.List;

import com.expenseApp.expenseApiTracker.entity.Expenses;

public interface ExpenseService {
	
	List<Expenses> getAllExpenses();

}

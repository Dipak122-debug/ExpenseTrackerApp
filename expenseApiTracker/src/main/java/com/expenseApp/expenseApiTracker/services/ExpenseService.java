package com.expenseApp.expenseApiTracker.services;

import java.util.List;

import com.expenseApp.expenseApiTracker.entity.Expenses;

public interface ExpenseService {
	
	List<Expenses> getAllExpenses();
	
	Expenses getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expenses saveExpenseDetails(Expenses expense);
	
	Expenses updateExpenseDetails(Long id, Expenses expense);

}

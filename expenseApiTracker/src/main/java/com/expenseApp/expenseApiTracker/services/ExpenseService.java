package com.expenseApp.expenseApiTracker.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expenseApp.expenseApiTracker.entity.Expenses;

public interface ExpenseService {
	
	Page<Expenses> getAllExpenses(Pageable page);
	
	Expenses getExpenseById(Long id);
	
	void deleteExpenseById(Long id);
	
	Expenses saveExpenseDetails(Expenses expense);
	
	Expenses updateExpenseDetails(Long id, Expenses expense);

}

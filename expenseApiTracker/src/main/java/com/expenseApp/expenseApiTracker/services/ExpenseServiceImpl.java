package com.expenseApp.expenseApiTracker.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.expenseApp.expenseApiTracker.entity.Expenses;
import com.expenseApp.expenseApiTracker.exceptions.ExpenseNotFoundException;
import com.expenseApp.expenseApiTracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public Page<Expenses> getAllExpenses(Pageable page){

		return expenseRepo.findAll(page);
		
	}
	
	@Override
	public Expenses getExpenseById(Long id) {
		
		Optional<Expenses> expenseObj = expenseRepo.findById(id);
		if(expenseObj.isPresent()) {
			return expenseObj.get();
		}
		throw new ExpenseNotFoundException("Expense is not found for the id "+id);
	}
	
	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}
	
	@Override
	public Expenses saveExpenseDetails(Expenses expense) {
		return expenseRepo.save(expense);
	}
	
	@Override
	public Expenses updateExpenseDetails(Long id, Expenses expense) {
		
		Expenses existingExpenseDetails = expenseRepo.findById(id).get();
		
		existingExpenseDetails.setName(null!=expense.getName() ? expense.getName() : existingExpenseDetails.getName());
		existingExpenseDetails.setDescription(null!=expense.getDescription() ? expense.getDescription() : existingExpenseDetails.getDescription());
		existingExpenseDetails.setCategory(null!=expense.getCategory() ? expense.getCategory() : existingExpenseDetails.getCategory());
		existingExpenseDetails.setAmount(null!=expense.getAmount() ? expense.getAmount() : existingExpenseDetails.getAmount());
		existingExpenseDetails.setDate(null!=expense.getDate() ? expense.getDate() : existingExpenseDetails.getDate());
		
		return expenseRepo.save(existingExpenseDetails);
	}
	
	@Override
	public List<Expenses> readByCategory(String category, Pageable page) {
		
		return expenseRepo.findByCategory(category, page).toList();
	}
	
	@Override
	public List<Expenses> readByName(String keyword, Pageable page) {
		
		return expenseRepo.findByNameContaining(keyword, page).toList();
	}
	
	@Override
	public List<Expenses> readByDate(Date startDate, Date endDate, Pageable page) {
		
		if(startDate == null) startDate = new Date(0);
		
		if(endDate == null) endDate = new Date(System.currentTimeMillis());
		
		return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
	}

}
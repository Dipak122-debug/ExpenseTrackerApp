package com.expenseApp.expenseApiTracker.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expenseApp.expenseApiTracker.entity.Expenses;
import com.expenseApp.expenseApiTracker.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService; 

	@GetMapping("/expenses")
	public List<Expenses> getAllExpenses(Pageable page){
		return expenseService.getAllExpenses(page).toList();
	}
	
	@GetMapping("/expenses/{id}")
	public Expenses getExpensesById(@PathVariable("id") Long id) {
		
		return expenseService.getExpenseById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseId(@RequestParam Long id) {
		 expenseService.deleteExpenseById(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expenses saveExpenseDetails(@Valid @RequestBody Expenses expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	
	@PutMapping("/expenses/{id}")
	public Expenses updateExpenseDetails(@PathVariable Long id, @RequestBody Expenses expense ){		
		return expenseService.updateExpenseDetails(id, expense);
	}
	
	@GetMapping("/expenses/category")
	public List<Expenses> getExpensesByCategory(@RequestParam String category, Pageable page){
		
		return expenseService.readByCategory(category, page);
		
	}
	
	@GetMapping("/expenses/name")
	public List<Expenses> getExpensesByName(@RequestParam String keyword, Pageable page){
		return expenseService.readByName(keyword, page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expenses> getExpensesByDates(@RequestParam(required=false) Date startDate,
			@RequestParam(required=false) Date endDate, Pageable page){
		
		return expenseService.readByDate(startDate, endDate, page);
		
	}
}

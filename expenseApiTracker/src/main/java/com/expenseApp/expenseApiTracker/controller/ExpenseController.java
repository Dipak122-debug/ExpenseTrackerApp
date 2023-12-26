package com.expenseApp.expenseApiTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.expenseApp.expenseApiTracker.entity.Expenses;
import com.expenseApp.expenseApiTracker.services.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService; 
	
	@GetMapping("/expenses")
	public List<Expenses> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/expenses/{id}")
	public Expenses getExpensesById(@PathVariable("id") Long id) {
		
		return expenseService.getExpenseById(id);
	}
	
	@DeleteMapping("/expenses")
	public void deleteExpenseId(@RequestParam Long id) {
		
		 expenseService.deleteExpenseById(id);
	}
	
	@PostMapping("/expenses")
	public Expenses saveExpenseDetails(@RequestBody Expenses expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	
	@PutMapping("/expenses/{id}")
	public Expenses updateExpenseDetails(@PathVariable Long id, @RequestBody Expenses expense ){		
		return expenseService.updateExpenseDetails(id, expense);
	}
	

	
}

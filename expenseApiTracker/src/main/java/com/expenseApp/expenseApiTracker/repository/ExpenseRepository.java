package com.expenseApp.expenseApiTracker.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseApp.expenseApiTracker.entity.Expenses;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {
	
	// SELECT * from tbl_expenses WHERE category=? --> this query runs behind thru hibernate.
	Page<Expenses> findByUserIdAndCategory(Long userId,String category, Pageable page);
	
	// SELECT * from tbl_expenses WHERE name="%keyword%"? --> this query runs behind thru hibernate.
	Page<Expenses> findByUserIdAndNameContaining(Long userId,String keyword, Pageable page);
	
	//SELECT * from tbl_expenses WHERE date BETWEEN 'startDate' AND 'endDate'
	Page<Expenses> findByUserIdAndDateBetween(Long userId,Date startDate, Date endDate, Pageable page);
	
	Page<Expenses> findByUserId(Long userId, Pageable page);
	
	Optional<Expenses> findByUserIdAndId(Long userId, Long expenseId);
}

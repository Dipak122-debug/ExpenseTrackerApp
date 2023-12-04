package com.expenseApp.expenseApiTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenseApp.expenseApiTracker.entity.Expenses;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

}

package com.aleshamray.expensetracker.service;

import java.util.List;

import com.aleshamray.expensetracker.domain.Expense;

public interface ExpenseServiceIF {

  List<Expense> findAll();
  
  void save(Expense expense);

  Expense findById(Long id);

  void delete(Long id);
}
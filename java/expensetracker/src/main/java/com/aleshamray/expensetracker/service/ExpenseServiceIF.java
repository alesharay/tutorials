package com.aleshamray.expensetracker.service;

import java.util.List;

import com.aleshamray.expensetracker.domain.Expense;

public interface ExpenseServiceIF {

  List<Expense> findAll();
  
}
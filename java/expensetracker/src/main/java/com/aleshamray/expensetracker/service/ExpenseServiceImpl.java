package com.aleshamray.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleshamray.expensetracker.domain.Expense;
import com.aleshamray.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseServiceIF {

  @Autowired
  ExpenseRepository expenseRepository;

  @Override
  public List<Expense> findAll() {
    return expenseRepository.findAll();
  }
  
}

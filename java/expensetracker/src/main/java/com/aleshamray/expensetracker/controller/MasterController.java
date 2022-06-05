package com.aleshamray.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aleshamray.expensetracker.domain.Expense;
import com.aleshamray.expensetracker.service.ExpenseServiceIF;

@Controller
public class MasterController {  

  @Autowired
  ExpenseServiceIF expenseService;

  @RequestMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView("home");
    mav.addObject("message", "List of expenses");
    List<Expense> expenses = expenseService.findAll();
    mav.addObject("expenses", expenses );
    System.out.println("\n" + expenses);
    return mav;
  }

}
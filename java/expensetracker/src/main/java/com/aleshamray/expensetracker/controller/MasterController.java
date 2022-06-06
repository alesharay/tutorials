package com.aleshamray.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping("/expense")
  public ModelAndView addExpense() {
    ModelAndView mav = new ModelAndView("expense");
    mav.addObject("expense", new Expense());
    return mav;
  }

  @PostMapping("/expense")
  public String save(@ModelAttribute("expense") Expense expense) {
    expenseService.save(expense);
    return "redirect:/";
  }

  @RequestMapping("/expense/{id}")
  public ModelAndView edit(@PathVariable("id") Long id) {
    ModelAndView mav = new ModelAndView("expense");
    Expense expense = expenseService.findById(id);
    mav.addObject("expense", expense);
    return mav;
  }

}
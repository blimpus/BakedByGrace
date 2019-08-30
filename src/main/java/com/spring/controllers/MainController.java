package com.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Order;
import com.spring.service.OrderService;

@Controller
//@RequestMapping("/")
public class MainController {
	
	
	  @Autowired 
	  private OrderService orderService;
	 
	
	  
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("hello");
	  return model;

	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderForm(HttpSession session, Model model) {
		Order order = (Order)session.getAttribute("order");
		if(order ==null) {
			order = new Order();
			order.setName("Austin");
			
		}
		
		model.addAttribute("order", order);
		return "orderForm";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order")Order order, BindingResult result) {
		System.out.println("name set to: " + order.getName());
		
		orderService.save(order);
		
		return "index";
	}
	
	

}

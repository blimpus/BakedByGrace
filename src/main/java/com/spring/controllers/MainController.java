package com.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.Order;
import com.spring.service.OrderService;

@Controller
//@RequestMapping("/")
public class MainController {
	
	
	  @Autowired 
	  private OrderService orderService;
	 
	
	  
		
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

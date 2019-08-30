package com.spring.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.auth.model.User;
import com.spring.auth.service.UserService;


@Controller
public class RegistrationController {

	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		if(user ==null) {
			user = new User();
			
		}
		
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user,BindingResult result) {
		System.out.println("name set to: " + user.getUsername());
		
		userService.save(user);
		
		return "index";
	}
}
package com.spring.auth.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.auth.model.User;
import com.spring.auth.model.UserDto;
import com.spring.auth.service.EmailExistsException;
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
		user.setEnabled(true);
		
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user,BindingResult result) {
		System.out.println("name set to: " + user.getUsername());
		
		
		Date date = new Date();
		user.setDateCreated(date);
		userService.save(user);
		
		return "index";
	}
	
	/* FIND A WAY TO USE THIS FOR REGISTRATION PROCESS */
	
	@RequestMapping(value = "/user/registration" , method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    UserDto userDto = new UserDto();
	    model.addAttribute("user", userDto);
	    return "registration";
	}
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result, WebRequest request, Errors errors) {
		
		User registered = new User();
	    if (!result.hasErrors()) {
	        registered = createUserAccount(accountDto, result);
	    }
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
	    if (result.hasErrors()) {
	        return new ModelAndView("registration", "user", accountDto);
	    } 
	    else {
	        return new ModelAndView("index", "user", accountDto);
	    }
		
	}
	
	private User createUserAccount(UserDto accountDto, BindingResult result) {
		User registered = null;
		try {
			registered = userService.registerNewUserAccount(accountDto);
		} catch (EmailExistsException e){
			return null;
		}
		return registered;
	}
}

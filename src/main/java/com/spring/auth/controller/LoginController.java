package com.spring.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.auth.model.Login;
import com.spring.auth.model.User;
import com.spring.auth.service.UserService;

@Controller
public class LoginController {

		@Autowired
		UserService userService;
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String showLogin(HttpSession session, Model model) {
			Login login = new Login();
//			User user = (User)session.getAttribute("user");
//			if(user ==null) {
//				user = new User();
//				
//			}
//			
			model.addAttribute("login", login);
			return "login";
		}
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String loginProcess(HttpSession session, @ModelAttribute("login")Login login, BindingResult result) {
			User user = userService.validateUser(login);
			
			if (user != null) {
				return "index";
			} else {
				return "register";
			}
		}
}

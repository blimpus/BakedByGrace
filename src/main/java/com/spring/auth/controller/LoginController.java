package com.spring.auth.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.auth.model.PdfUserDetails;
import com.spring.auth.model.User;
import com.spring.auth.service.UserService;

@Controller
public class LoginController {

		@Autowired
		UserService userService;
		
		private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	    @RequestMapping(value = "/login", method = RequestMethod.GET)

	    public String login() {

	        return "login";

	    }

	    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)

	    public String loginError(Model model) {

	        log.info("Login attempt failed");

	        model.addAttribute("error", "true");

	        return "login";

	    }

	    @RequestMapping(value = "/logout", method = RequestMethod.GET)

	    public String logout(SessionStatus session) {

	        SecurityContextHolder.getContext().setAuthentication(null);

	        session.setComplete();

	        return "redirect:/welcome";

	    }

	    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)

	    public String postLogin(Model model, HttpSession session) {

	        log.info("postLogin()");

	        // read principal out of security context and set it to session

	        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

	        validatePrinciple(authentication.getPrincipal());

	        User loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();

	        model.addAttribute("currentUser", loggedInUser.getUsername());

	        session.setAttribute("userId", loggedInUser.getUserId());

	        return "redirect:/";

	    }

	    private void validatePrinciple(Object principal) {

	        if (!(principal instanceof PdfUserDetails)) {

	            throw new  IllegalArgumentException("Principal can not be null!");

	        }

	    }
	    
	    
}

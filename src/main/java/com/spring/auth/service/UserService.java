package com.spring.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.auth.model.Login;
import com.spring.auth.model.Role;
import com.spring.auth.model.User;
import com.spring.auth.repository.RoleRepository;
import com.spring.auth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	public void save(User user, Role role) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		roleRepository.save(role);
		// TODO Auto-generated method stub
		
	}
	
	public User validateUser(Login login) {
		List<User> users = userRepository.findByUsername(login.getUsername());
		
		if(users.size()==0) {
			return null;
		} 
		if(passwordEncoder.matches(login.getPassword(), users.get(0).getPassword())) {
			System.out.println("returning user with username of: " + users.get(0).getUsername() + " and password: " + users.get(0).getPassword());
			return users.get(0);
			
		} else {
			return null;
		}
	}

}

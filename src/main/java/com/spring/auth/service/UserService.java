package com.spring.auth.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.auth.model.User;
import com.spring.auth.model.UserDto;
import com.spring.auth.repository.UserJpaRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserJpaRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
	}
	
	/* FIGURE OUT HOW TO IMPLEMENT THIS FOR USER REGISTRATION */
	
	@Override
	@Transactional
	public User registerNewUserAccount(UserDto accountDto)throws EmailExistsException {
	         
	        if (emailExist(accountDto.getEmail())) {  
	            throw new EmailExistsException("There is an account with that email address: " + accountDto.getEmail());
	        }
	        
	        User user = new User();
	        user.setEmail(accountDto.getEmail());
	        user.setPassword(accountDto.getPassword());
	        user.setUsername(accountDto.getEmail());
	        
	        return userRepository.save(user);
				
	}

	private boolean emailExist(String email) {
		User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }


}

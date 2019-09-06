package com.spring.auth.service;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.auth.model.Authority;
import com.spring.auth.model.Role;
import com.spring.auth.model.User;
import com.spring.auth.model.UserDto;
import com.spring.auth.repository.AuthorityJpaRepository;
import com.spring.auth.repository.RoleJpaRepository;
import com.spring.auth.repository.UserJpaRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserJpaRepository userRepository;
	
	@Autowired
	private AuthorityJpaRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleJpaRepository roleRepository;
	

	public void save(User user, Authority auth) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		authorityRepository.save(auth);
		createRoleIfNotFound("ROLE_USER");
		
		Role userRole = roleRepository.findByName("ROLE_USER");
		user.setRoles(Arrays.asList(userRole));
		
		userRepository.save(user);
		
	}
	
 
    @Transactional
    private Role createRoleIfNotFound(
      String name) {
  
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
//            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
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

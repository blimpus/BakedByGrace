package com.spring.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.auth.model.PdfUserDetails;
import com.spring.auth.model.User;
import com.spring.auth.repository.UserJpaRepository;
import org.slf4j.*;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserJpaRepository userRepository;
	
	private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(email);
//		if (user == null) {
//			throw new UsernameNotFoundException("No user found with username " + email);
//		}
//		boolean enabled = true;
//		boolean accountNonExpired = true;
//		boolean credentialsNonExpired = true;
//		boolean accountNonLocked = true;
//		
//		return  new org.springframework.security.core.userdetails.User
//		          (user.getEmail(), 
//		          user.getPassword().toLowerCase(), enabled, accountNonExpired, 
//		          credentialsNonExpired, accountNonLocked, 
//		          getAuthorities("String"));
//	}
	
	private static List<GrantedAuthority> getAuthorities (String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));
        
        return authorities;
    }
	
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> users = userRepository.findByUsername(username);

        if (users.size() == 0) {

            throw new UsernameNotFoundException("User not found.");

        }
        
        User user = users.get(0);

        log.info("loadUserByUsername() : {}", username);

        return new PdfUserDetails(user);

    }

}

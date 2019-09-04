package com.spring.auth.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

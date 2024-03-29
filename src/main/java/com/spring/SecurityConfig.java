package com.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.auth.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean

	public UserDetailsService userDetailsService() {

		return new MyUserDetailsService();

	}

	@Bean

	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	@Bean

	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());

		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;

	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) {

		auth.authenticationProvider(authenticationProvider());

	}

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		http

				.authorizeRequests().antMatchers("/order").hasAnyRole("ADMIN", "USER")

				.and()

				.authorizeRequests().antMatchers("/login", "/resource/**").permitAll()

				.and()

				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()

				.loginProcessingUrl("/doLogin")

				.successForwardUrl("/postLogin")

				.failureUrl("/loginFailed")

				.and()

				.logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()

				.and()

				.csrf().disable();

	}

}

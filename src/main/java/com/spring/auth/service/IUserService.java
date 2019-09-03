package com.spring.auth.service;


import com.spring.auth.model.User;
import com.spring.auth.model.UserDto;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto)     
		      throws EmailExistsException;
}

package com.spring.auth.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.spring.auth.validator.PasswordMatches;
import com.spring.auth.validator.ValidEmail;

@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;

	@NotNull
    @NotEmpty
    private String password;

	private String matchingPassword;

	@NotNull
    @NotEmpty
    @ValidEmail
    private String email;

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
     
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
     
    public void setPassword(String password) {
		this.password = password;
	}
}

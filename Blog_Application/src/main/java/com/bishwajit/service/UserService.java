package com.bishwajit.service;

import com.bishwajit.binding.LoginForm;
import com.bishwajit.binding.RegistrationForm;

public interface UserService {

	String registerUser(RegistrationForm form);
	
	boolean loginUser(LoginForm form);
	
}

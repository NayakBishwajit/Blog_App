package com.bishwajit.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishwajit.binding.LoginForm;
import com.bishwajit.binding.RegistrationForm;
import com.bishwajit.constants.AppConstants;
import com.bishwajit.entity.UserDtlsEntity;
import com.bishwajit.repo.UserDtlsRepository;
import com.bishwajit.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDtlsRepository userRepo;
	
	@Autowired
	private HttpSession session;

	@Override
	public String registerUser(RegistrationForm form) {
		
		UserDtlsEntity entity = userRepo.findByEmail(form.getEmail());
		
		if(entity != null) {
			return AppConstants.EMAIL_EXIST_MSG;
		}
		
		UserDtlsEntity user = new UserDtlsEntity();
		BeanUtils.copyProperties(form, user);
		
		userRepo.save(user);
		
		return AppConstants.REGISTRATION_SUCC_MSG;
	}

	@Override
	public boolean loginUser(LoginForm form) {
		UserDtlsEntity entity = userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());

		if(entity == null) {
			return false;
		}
		
		session.setAttribute(AppConstants.SESSION_USERID, entity.getUserId());
		
		return true;
	}

}

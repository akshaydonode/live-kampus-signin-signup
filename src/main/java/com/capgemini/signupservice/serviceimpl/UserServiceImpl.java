package com.capgemini.signupservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.signupservice.dao.UserDao;
import com.capgemini.signupservice.entity.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	public User createProfile(User user) {
		return userDao.save(user);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	
}

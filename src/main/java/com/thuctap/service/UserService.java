package com.thuctap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thuctap.DAO.UserDAO;
import com.thuctap.entities.User;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User loadUserByUserName(final String username) {
		return userDAO.loadUserByUserName(username);
	}
	
	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}
	
}

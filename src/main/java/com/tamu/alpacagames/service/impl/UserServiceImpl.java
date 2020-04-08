package com.tamu.alpacagames.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamu.alpacagames.model.Users;
import com.tamu.alpacagames.repository.UserRepository;
import com.tamu.alpacagames.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Users createUser(Users user) {
		
		return userRepository.save(user);
	}

}

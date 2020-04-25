package com.tamu.alpacagames.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public boolean validateUser(Users user) {
		System.out.println("user tring to login--->"+user.getUsername());
		System.out.println("user check---->"+userRepository.findByUsername(user.getUsername()));
		Optional<Users> fetchedUser = userRepository.findByUsername(user.getUsername());
		//return (fetchedUser.isPresent() && fetchedUser.get().getPassword().equals(user.getPassword()))?true:false;
		return (fetchedUser.isPresent() && fetchedUser.get().getPassword().equals(user.getPassword()))?true:false;
	}

	@Override
	public List<Users> getUsers(){
		return userRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}

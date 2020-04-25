package com.tamu.alpacagames.service;

import java.util.List;

import com.tamu.alpacagames.model.Users;

public interface UserService {
	Users createUser(Users user);
	boolean validateUser(Users user);
	List<Users> getUsers();
	void deleteById(Long id);
}

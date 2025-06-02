package com.crud.simple.service;

import java.util.List;

import com.crud.simple.entity.User;

public interface UserService {

	List<User> getAllUsers();
	User getUser(int id);
	String registerUser(User user);
	User updateUser(int id,User user);
	String deleteUser(int id);
}

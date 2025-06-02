package com.crud.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.simple.entity.User;
import com.crud.simple.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User getUser(int id) {
		User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : "+id));
		return user;
	}

	@Override
	public String registerUser(User user) {
		userRepo.save(user);
		return "User registered";
	}

	@Override
	public User updateUser(int id,User user) {
		User savedUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : "+id));
		if(user.getAddress()!=null || !user.getAddress().isEmpty()) savedUser.setAddress(user.getAddress());
		if(user.getFirst_name()!=null || !user.getFirst_name().isEmpty()) savedUser.setFirst_name(user.getFirst_name());
		if(user.getLast_name()!=null || !user.getLast_name().isEmpty()) savedUser.setLast_name(user.getLast_name());
		if(user.getPhone_number()!=null || !user.getPhone_number().isEmpty()) savedUser.setPhone_number(user.getPhone_number());
		if(user.getEmail()!=null || !user.getEmail().isEmpty()) savedUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(savedUser);

		return updatedUser;
	}

	@Override
	public String deleteUser(int id) {
		User savedUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : "+id));
		userRepo.delete(savedUser);
		return "User deleted";
	}

}

package com.backend.service.springbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.service.springbackend.exception.ResourceNotFoundException;
import com.backend.service.springbackend.model.User;
import com.backend.service.springbackend.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User deleteById(long id){
	 	User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
 		userRepository.deleteById(id);
 		return user;
 	}
	
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
	}
	
	public User update(long id, User user) {
		userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
		user.setId(id);
		return userRepository.save(user);
	}
}

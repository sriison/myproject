package com.backend.service.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.service.springbackend.model.User;
import com.backend.service.springbackend.repository.UserRepository;
import com.backend.service.springbackend.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class UserController {
	@Autowired
	private UserService userService;
	
	//get all employees
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	//posting data into user table
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@DeleteMapping("/users/{id}")
 	public User deleteById(@PathVariable Long id){
 	
 		 return userService.deleteById(id);
 		
 	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PutMapping("/users/{id}")
	public User update(@PathVariable Long id,@RequestBody User user) {
		return userService.update(id,user);
	}
}

package com.capgemini.signupservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.signupservice.entity.User;
import com.capgemini.signupservice.serviceimpl.UserServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping("/signUp")
	public ResponseEntity<User> registerNewAccount(@RequestBody User user) {


		User user1 = service.createProfile(user);
		// System.out.println(u);
	//	System.out.println(user.getDateOfBirth());

		return new ResponseEntity<User>(user1,HttpStatus.CREATED);

	}

	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> logInDetailsForUser(@PathVariable String email, @PathVariable String password)
			throws NullPointerException {

		 User user1 = service.findByEmail(email);
	
		System.out.println(user1);

		 
		if((user1.getEmail().equals(email) && (user1.getPassword().equals(password)))) {
			
			return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

	}
	

}

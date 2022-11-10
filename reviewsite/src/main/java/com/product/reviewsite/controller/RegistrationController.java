package com.product.reviewsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.reviewsite.entities.*;
import com.product.reviewsite.services.RegistrationServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	@Autowired
	private RegistrationServices service;
	@GetMapping("/testMethod")
	public String testMethod() {
		return new String("testing feature");
	}
	
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception {
		System.out.println("testing user  register"+user);
		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if (userObj != null) {
				throw new Exception("User with " + tempEmailId + " is already exist");
			}
		}
		User userObj = null;
		String password = user.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		user.setPassword(hashedPassword);
		userObj = service.saveUser(user);
		return userObj;
	}


}

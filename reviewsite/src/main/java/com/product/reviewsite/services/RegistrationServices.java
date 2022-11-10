package com.product.reviewsite.services;

import com.product.reviewsite.entities.User;

public interface RegistrationServices {
public User saveUser(User user);
	
	public User fetchUserByEmailId(String emailId);
	
	public Long countAllRegistrated();

}

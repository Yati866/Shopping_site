package com.product.reviewsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.product.reviewsite.entities.User;
import com.product.reviewsite.model.CustomerUserDetails;



@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private RegistrationServiceImpl repository;

	/**
	 * This function is used to check and return the user present in the database.
	 */
	@Override
	public CustomerUserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		final User user = this.repository.fetchUserByEmailId(emailId);
		if (user == null) {
			return null;
		} else {
			return new CustomerUserDetails(user);
		}
	}

}
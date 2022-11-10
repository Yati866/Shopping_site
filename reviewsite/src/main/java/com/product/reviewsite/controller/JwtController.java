package com.product.reviewsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.reviewsite.helper.JwtHelper;
import com.product.reviewsite.model.CustomerUserDetails;
import com.product.reviewsite.model.JwtRequest;
import com.product.reviewsite.model.JwtResponse;
import com.product.reviewsite.services.CustomerUserDetailsService;


@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtHelper jwtTokenUtil;
	@Autowired
	private CustomerUserDetailsService userDetailsService;

	/*
	 * This API is used to accept the request from client side and authenticate
	 * userName and password
	 * 
	 * @Param RequestBody
	 * 
	 * @Return Token as JSON format with userName
	 */
	@PostMapping("/auth")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmailId(), authenticationRequest.getPassword());
		final CustomerUserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getEmailId());
		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(new JwtResponse(token, userDetails.userName()));
	}

	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}

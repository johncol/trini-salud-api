package com.trinisalud.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trinisalud.domain.User;
import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;
import com.trinisalud.repository.UserRepository;

@Component("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationServiceImpl.class.getName()); 
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		User user = userRepository.findByUsername(request.getUsername());
		LOGGER.info("user found: " + user);
		if (request.getUsername().equals("johncol") && request.getPassword().equals("pass")) {
			return new AuthenticationResponse(true, "admin", "zzxydc");
		}
		return new AuthenticationResponse(false);
	}

}

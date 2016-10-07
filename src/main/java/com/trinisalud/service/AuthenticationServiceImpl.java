package com.trinisalud.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trinisalud.domain.TriniSaludUser;
import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;
import com.trinisalud.repository.TriniSaludUserRepository;

@Component("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationServiceImpl.class.getName()); 
	
	@Autowired
	private TriniSaludUserRepository userRepository;

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		TriniSaludUser user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		LOGGER.info("user: " + user);
		if (user != null) {
			return new AuthenticationResponse(true, user.getRole(), "TOKEN");
		}
		return new AuthenticationResponse(false);
	}

}

package com.trinisalud.service;

import java.util.logging.Logger;

import javax.persistence.PersistenceException;

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
	public AuthenticationResponse authenticate(AuthenticationRequest request) throws ServiceException {
		try {
			User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
			if (user != null) {
				return new AuthenticationResponse(true, user.getRole(), "TOKEN");
			}
			return new AuthenticationResponse(false);
		} catch (PersistenceException e) {
			LOGGER.severe("Error looking for user " + request.getUsername() + " - " + e);
			throw new ServiceException("Ocurrio un error verificando las credenciales");
		}
	}

}

package com.trinisalud.service;

import org.springframework.stereotype.Component;

import com.trinisalud.web.authentication.AuthenticationRequest;
import com.trinisalud.web.authentication.AuthenticationResponse;

@Component("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		if (request.getUsername().equals("johncol") && request.getPassword().equals("pass")) {
			return new AuthenticationResponse(true, "admin", "zzxydc");
		}
		return new AuthenticationResponse(false);
	}

}

package com.trinisalud.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;
import com.trinisalud.service.AuthenticationService;
import com.trinisalud.service.ServiceException;;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class.getName());
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/on")
	public ApiResponse<AuthenticationResponse> on(@RequestBody AuthenticationRequest request) {
		LOGGER.info("request: " + request);
		try {
			AuthenticationResponse response = authService.authenticate(request);
			return new ApiResponse<AuthenticationResponse>(response.isAuthenticated(), response.isAuthenticated() ? "ok" : "Credenciales inorrectas", response);
		} catch (ServiceException e) {
			return new ApiResponse<AuthenticationResponse>(false, e.getMessage());
		}
	}

}

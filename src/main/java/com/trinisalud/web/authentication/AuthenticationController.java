package com.trinisalud.web.authentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;
import com.trinisalud.service.AuthenticationService;
import com.trinisalud.web.ApiResponse;;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationController.class.getName());
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/on")
	public ApiResponse<AuthenticationResponse> on(@RequestBody AuthenticationRequest request) {
		LOGGER.info("request: " + request);
		return new ApiResponse<AuthenticationResponse>(true, "Ok", authService.authenticate(request));
	}

}

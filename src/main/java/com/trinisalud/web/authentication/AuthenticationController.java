package com.trinisalud.web.authentication;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.service.AuthenticationService;
import com.trinisalud.web.ApiResponse;;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/authentication/on")
	public ApiResponse<AuthenticationResponse> on(@RequestBody AuthenticationRequest request) {
		System.out.println("Request: " + request);
		return new ApiResponse<AuthenticationResponse>(200, "Ok", authService.authenticate(request));
	}

}

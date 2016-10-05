package com.trinisalud.web.authentication;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;
import com.trinisalud.service.AuthenticationService;
import com.trinisalud.web.ApiResponse;;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;

	@PostMapping("/on")
	public ApiResponse<AuthenticationResponse> on(@RequestBody AuthenticationRequest request) {
		System.out.println("AuthenticationResponse on request: " + request);
		return new ApiResponse<AuthenticationResponse>(200, "Ok", authService.authenticate(request));
	}

}

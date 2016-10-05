package com.trinisalud.service;

import com.trinisalud.web.authentication.AuthenticationRequest;
import com.trinisalud.web.authentication.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticate(AuthenticationRequest request);

}

package com.trinisalud.service;

import com.trinisalud.model.authentication.AuthenticationRequest;
import com.trinisalud.model.authentication.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticate(AuthenticationRequest request);

}

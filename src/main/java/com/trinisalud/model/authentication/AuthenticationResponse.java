package com.trinisalud.model.authentication;

public class AuthenticationResponse {

	private final boolean authenticated;
	private final String role;
	private final String token;

	public AuthenticationResponse(boolean authenticated, String role, String token) {
		super();
		this.authenticated = authenticated;
		this.role = role;
		this.token = token;
	}

	public AuthenticationResponse(boolean authenticated) {
		this(authenticated, null, null);
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public String getRole() {
		return role;
	}

	public String getToken() {
		return token;
	}

}

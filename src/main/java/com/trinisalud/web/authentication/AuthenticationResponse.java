package com.trinisalud.web.authentication;

public class AuthenticationResponse {

	private final boolean success;
	private final String role;
	private final String token;

	public AuthenticationResponse(boolean success, String role, String token) {
		super();
		this.success = success;
		this.role = role;
		this.token = token;
	}

	public AuthenticationResponse(boolean success) {
		this(success, null, null);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getRole() {
		return role;
	}

	public String getToken() {
		return token;
	}

}

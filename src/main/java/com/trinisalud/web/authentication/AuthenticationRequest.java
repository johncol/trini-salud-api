package com.trinisalud.web.authentication;

public class AuthenticationRequest {

	private String username;
	private String password;

	public AuthenticationRequest() {}

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "AuthenticationRequest[username=" + username + ", password=" + password + "]";
	}

}

package com.trinisalud.service;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -4369119628065090993L;
	
	public ServiceException(String message) {
		super(message);
	}

}

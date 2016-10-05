package com.trinisalud.web;

public class ApiResponse<T> {

	private final int status;
	private final String message;
	private final T data;

	public ApiResponse(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

}

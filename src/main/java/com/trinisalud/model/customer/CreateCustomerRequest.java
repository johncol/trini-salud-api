package com.trinisalud.model.customer;

public class CreateCustomerRequest {

	private String identification;
	private String name;
	private String email;
	private String phone;
	private String password;

	public CreateCustomerRequest() {}

	public CreateCustomerRequest(String identification, String name, String email, String phone, String password) {
		super();
		this.identification = identification;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CreateCustomerRequest [identification=" + identification + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + "]";
	}

}

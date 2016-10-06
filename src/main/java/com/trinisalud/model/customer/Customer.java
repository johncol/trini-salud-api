package com.trinisalud.model.customer;

public class Customer {

	private String identification;
	private String name;

	public Customer() {
	}

	public Customer(String identification, String name) {
		super();
		this.identification = identification;
		this.name = name;
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

	@Override
	public String toString() {
		return "Customer [identification=" + identification + ", name=" + name + "]";
	}

}

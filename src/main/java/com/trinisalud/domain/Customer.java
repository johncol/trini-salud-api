package com.trinisalud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "ts_customer")
public class Customer {

	@Id
	@Column(nullable = false)
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String email;
	
	@Column(nullable = true)
	private String phone;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "username")
	private User username;

	protected Customer() {
	}

	public Customer(String id, String name, String email, String phone, User username) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", username="
				+ username + "]";
	}

}

package com.trinisalud.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity(name = "ts_patient")
public class Patient {

	@Id
	@Column(nullable = false)
	private String id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private char gender;

	@Column(nullable = false)
	private String eps;

	@Column(nullable = false)
	private Date birthdate;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String phone;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer")
	@LazyToOne(value = LazyToOneOption.PROXY)
	private Customer customer;

	protected Patient() {
	}

	public Patient(String id, String name, String email, char gender, String eps, Date birthdate, String address,
			String phone, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.eps = eps;
		this.birthdate = birthdate;
		this.address = address;
		this.phone = phone;
		this.customer = customer;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", eps=" + eps
				+ ", birthdate=" + birthdate + ", address=" + address + ", phone=" + phone + ", customer=" + customer
				+ "]";
	}

}

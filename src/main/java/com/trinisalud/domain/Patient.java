package com.trinisalud.domain;

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
	private char gender;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer")
	@LazyToOne(value = LazyToOneOption.PROXY)
	private Customer customer;

	protected Patient() {
	}

	public Patient(String id, String name, char gender, Customer customer) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", customer=" + customer + "]";
	}

}

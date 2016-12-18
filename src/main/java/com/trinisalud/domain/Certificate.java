package com.trinisalud.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity(name = "ts_certificate")
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private byte[] file;

	@ManyToOne(optional = true)
	@JoinColumn(name = "patient")
	@LazyToOne(value = LazyToOneOption.PROXY)
	private Patient patient;

	@ManyToOne(optional = false)
	@JoinColumn(name = "customer")
	@LazyToOne(value = LazyToOneOption.PROXY)
	private Customer customer;

	protected Certificate() {
	}

	public Certificate(String name, Date date, byte[] file, Patient patient, Customer customer) {
		super();
		this.name = name;
		this.date = date;
		this.file = file;
		this.patient = patient;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

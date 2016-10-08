package com.trinisalud.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@Column(nullable = true)
	private String file;
	// private Blob file;

	@ManyToOne(optional = false)
	@JoinColumn(name = "patient")
	@LazyToOne(value = LazyToOneOption.PROXY)
	private Patient patient;

	protected Certificate() {
	}

	public Certificate(String name, Date date, String file, Patient patient) {
		super();
		this.name = name;
		this.date = date;
		this.file = file;
		this.patient = patient;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + ", date=" + date + ", file=" + file + ", patient=" + patient
				+ "]";
	}

}

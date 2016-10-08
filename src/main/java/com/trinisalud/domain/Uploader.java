package com.trinisalud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "ts_uploader")
public class Uploader {
	
	@Id
	@Column(nullable = false)
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "username")
	private User username;
	
	protected Uploader() {
	}

	public Uploader(String id, String name, User username) {
		super();
		this.id = id;
		this.name = name;
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

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Uploader [id=" + id + ", name=" + name + ", username=" + username + "]";
	}
	
}

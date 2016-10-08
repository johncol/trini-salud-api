package com.trinisalud.model.certificate.search;

public class CertificateResponse {

	private String id;
	private String name;

	public CertificateResponse() {
	}

	public CertificateResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + "]";
	}

}

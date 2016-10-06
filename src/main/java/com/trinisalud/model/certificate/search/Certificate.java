package com.trinisalud.model.certificate.search;

public class Certificate {

	private String certificateId;
	private String name;

	public Certificate() {
	}

	public Certificate(String certificateId, String name) {
		super();
		this.certificateId = certificateId;
		this.name = name;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", name=" + name + "]";
	}

}

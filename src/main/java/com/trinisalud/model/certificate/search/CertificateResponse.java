package com.trinisalud.model.certificate.search;

public class CertificateResponse {

	private String certificateId;
	private String name;

	public CertificateResponse() {
	}

	public CertificateResponse(String certificateId, String name) {
		super();
		this.certificateId = certificateId;
		this.name = name;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String id) {
		this.certificateId = id;
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

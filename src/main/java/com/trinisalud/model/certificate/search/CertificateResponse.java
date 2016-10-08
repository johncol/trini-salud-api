package com.trinisalud.model.certificate.search;

public class CertificateResponse {

	private long certificateId;
	private String name;

	public CertificateResponse() {
	}

	public CertificateResponse(long certificateId, String name) {
		super();
		this.certificateId = certificateId;
		this.name = name;
	}

	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
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

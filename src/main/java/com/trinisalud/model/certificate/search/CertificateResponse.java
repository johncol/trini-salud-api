package com.trinisalud.model.certificate.search;

public class CertificateResponse {

	private String certificateId;
	private String name;
	private String date;

	public CertificateResponse() {
	}

	public CertificateResponse(String certificateId, String name, String date) {
		super();
		this.certificateId = certificateId;
		this.name = name;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Certificate [certificateId=" + certificateId + ", name=" + name + ", date=" + date + "]";
	}

}

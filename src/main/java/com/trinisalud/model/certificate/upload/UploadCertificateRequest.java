package com.trinisalud.model.certificate.upload;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UploadCertificateRequest {
	
	private PatientData patient;
	private CertificateData certificate;
	private String customer;
	
	public UploadCertificateRequest() {}

	public UploadCertificateRequest(PatientData patient, CertificateData certificate, String customer) {
		super();
		this.patient = patient;
		this.certificate = certificate;
		this.customer = customer;
	}

	public PatientData getPatient() {
		return patient;
	}

	public void setPatient(PatientData patient) {
		this.patient = patient;
	}

	public CertificateData getCertificate() {
		return certificate;
	}

	public void setCertificate(CertificateData certificate) {
		this.certificate = certificate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

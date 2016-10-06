package com.trinisalud.model.certificate.search;

import java.util.List;

public class SearchCertificateResponse {

	private Patient patient;
	private List<Certificate> certificates;

	public SearchCertificateResponse() {
	}

	public SearchCertificateResponse(Patient patient, List<Certificate> certificates) {
		super();
		this.patient = patient;
		this.certificates = certificates;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "SearchCertificateResponse [patient=" + patient + ", certificates=" + certificates + "]";
	}

}

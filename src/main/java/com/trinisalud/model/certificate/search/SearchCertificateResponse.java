package com.trinisalud.model.certificate.search;

import java.util.List;

public class SearchCertificateResponse {

	private PatientResponse patient;
	private List<CertificateResponse> certificates;

	public SearchCertificateResponse() {
	}

	public SearchCertificateResponse(PatientResponse patient, List<CertificateResponse> certificates) {
		super();
		this.patient = patient;
		this.certificates = certificates;
	}

	public PatientResponse getPatient() {
		return patient;
	}

	public void setPatient(PatientResponse patient) {
		this.patient = patient;
	}

	public List<CertificateResponse> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<CertificateResponse> certificates) {
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "SearchCertificateResponse [patient=" + patient + ", certificates=" + certificates + "]";
	}

}

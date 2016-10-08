package com.trinisalud.model.certificate.upload;

public class UploadCertificateResponse {
	
	private String certificateId;
	private String certificateName;
	
	public UploadCertificateResponse() {}

	public UploadCertificateResponse(String certificateId, String certificateName) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	@Override
	public String toString() {
		return "UploadCertificateResponse [certificateId=" + certificateId + ", certificateName=" + certificateName
				+ "]";
	}

}

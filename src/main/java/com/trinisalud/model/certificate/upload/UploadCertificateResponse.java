package com.trinisalud.model.certificate.upload;

public class UploadCertificateResponse {
	
	private String certificateId;
	private String certificateName;
	private String customerId;
	
	public UploadCertificateResponse() {}

	public UploadCertificateResponse(boolean success, String message, String certificateId, String certificateName,
			String customerId) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.customerId = customerId;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "UploadCertificateResponse [certificateId=" + certificateId + ", certificateName=" + certificateName
				+ ", customerId=" + customerId + "]";
	}

}

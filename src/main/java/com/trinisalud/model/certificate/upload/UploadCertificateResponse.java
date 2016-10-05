package com.trinisalud.model.certificate.upload;

public class UploadCertificateResponse {
	
	private boolean success;
	private String message;
	private String certificateId;
	private String certificateName;
	private String customerId;
	
	public UploadCertificateResponse() {}

	public UploadCertificateResponse(boolean success, String message, String certificateId, String certificateName,
			String customerId) {
		super();
		this.success = success;
		this.message = message;
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.customerId = customerId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		return "UploadCertificateResponse [success=" + success + ", message=" + message + ", certificateId="
				+ certificateId + ", certificateName=" + certificateName + ", customerId=" + customerId + "]";
	}

}

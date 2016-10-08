package com.trinisalud.model.certificate.upload;

public class UploadCertificateResponse {
	
	private long certificateId;
	private String certificateName;
	
	public UploadCertificateResponse() {}

	public UploadCertificateResponse(long certificateId, String certificateName) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
	}

	public long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(long certificateId) {
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

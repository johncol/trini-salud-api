package com.trinisalud.service;

import org.springframework.stereotype.Component;

import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;

@Component("certificateService")
public class CertificateServiceImpl implements CertificateService {

	@Override
	public UploadCertificateResponse uploadCertificate(UploadCertificateRequest request) {
		return new UploadCertificateResponse(true, "Well done", "afdsfsd", "Trigliceridos", "1019034461");
	}

	@Override
	public byte[] getCertificateBytes(String certificateId) {
		return new byte[1];
	}

}

package com.trinisalud.service;

import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;

public interface CertificateService {
	
	UploadCertificateResponse uploadCertificate(UploadCertificateRequest request);

}

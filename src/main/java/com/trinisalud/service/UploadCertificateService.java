package com.trinisalud.service;

import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;

public interface UploadCertificateService {
	
	UploadCertificateResponse upload(UploadCertificateRequest request) throws ServiceException;

}

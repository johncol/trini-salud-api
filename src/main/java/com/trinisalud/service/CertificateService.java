package com.trinisalud.service;

import com.trinisalud.model.certificate.search.SearchCertificateResponse;
import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;

public interface CertificateService {
	
	UploadCertificateResponse uploadCertificate(UploadCertificateRequest request) throws ServiceException;
	
	byte[] getCertificateBytes(String certificateId) throws ServiceException;
	
	SearchCertificateResponse search(String patientId) throws ServiceException;

}

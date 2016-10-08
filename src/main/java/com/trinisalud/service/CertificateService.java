package com.trinisalud.service;

import com.trinisalud.model.certificate.search.SearchCertificateResponse;

public interface CertificateService {
	
	byte[] getCertificateBytes(String certificateId) throws ServiceException;
	
	SearchCertificateResponse search(String patientId) throws ServiceException;

}

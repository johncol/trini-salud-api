package com.trinisalud.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trinisalud.model.certificate.search.CertificateResponse;
import com.trinisalud.model.certificate.search.PatientResponse;
import com.trinisalud.model.certificate.search.SearchCertificateResponse;

@Component("certificateService")
public class CertificateServiceImpl implements CertificateService {

	@Override
	public byte[] getCertificateBytes(String certificateId) throws ServiceException {
		return new byte[1];
	}

	@Override
	public SearchCertificateResponse search(String patientId) throws ServiceException {
		PatientResponse patient = new PatientResponse(patientId, "john", "Hombre", 27, 41545465456L, "Calle 26", "3052315411", "john@mail.com", "sura", "dasdsadas");
		List<CertificateResponse> certificates = Arrays.asList(
				new CertificateResponse("1", "Trigliceridos"),
				new CertificateResponse("2", "Electro"),
				new CertificateResponse("3", "SIDA"),
				new CertificateResponse("4", "Imperactividad")
		);
		return new SearchCertificateResponse(patient, certificates);
	}

}

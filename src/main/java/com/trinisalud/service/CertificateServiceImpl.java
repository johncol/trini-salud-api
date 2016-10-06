package com.trinisalud.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trinisalud.model.certificate.search.Certificate;
import com.trinisalud.model.certificate.search.Patient;
import com.trinisalud.model.certificate.search.SearchCertificateResponse;
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

	@Override
	public SearchCertificateResponse search(String patientId) {
		Patient patient = new Patient(patientId, "john", "Hombre", 27, 41545465456L, "Calle 26", "3052315411", "john@mail.com", "sura", "dasdsadas");
		List<Certificate> certificates = Arrays.asList(
				new Certificate("1", "Trigliceridos"),
				new Certificate("2", "Electro"),
				new Certificate("3", "SIDA"),
				new Certificate("4", "Imperactividad")
		);
		return new SearchCertificateResponse(patient, certificates);
	}

}

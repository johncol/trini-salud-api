package com.trinisalud.service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trinisalud.domain.Certificate;
import com.trinisalud.domain.Patient;
import com.trinisalud.model.certificate.search.CertificateResponse;
import com.trinisalud.model.certificate.search.PatientResponse;
import com.trinisalud.model.certificate.search.PatientResponse.PatientResponseBuilder;
import com.trinisalud.model.certificate.search.SearchCertificateResponse;
import com.trinisalud.repository.CertificateRepository;
import com.trinisalud.repository.PatientRepository;

@Component("certificateService")
public class CertificateServiceImpl implements CertificateService {
	
	private static final Logger LOGGER = Logger.getLogger(CertificateServiceImpl.class.getName());

	@Autowired
	private CertificateRepository certificateRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public byte[] getCertificateBytes(String certificateId) throws ServiceException {
		try {
			Certificate certificate = certificateRepository.findOne(Long.parseLong(certificateId));
			return certificate.getFile();
		} catch (PersistenceException e) {
			LOGGER.severe("Error gettring certificate " + certificateId + " - " + e);
			throw new ServiceException("Ocurrio un error");
		}
	}

	@Override
	public SearchCertificateResponse search(String patientId) throws ServiceException {
		try {
			PatientResponse patient = findAndMapPatient(patientId);
			List<CertificateResponse> certificates = findAllPatientCertificates(patientId);
			return new SearchCertificateResponse(patient, certificates);
		} catch (PersistenceException e) {
			LOGGER.severe("Error searching certificates for patient with id " + patientId + " - " + e);
			throw new ServiceException("Ocurrio un error en la búsqueda");
		}
	}

	@Override
	public SearchCertificateResponse searchForCustomer(String patientId, String customerId) throws ServiceException {
		try {
			PatientResponse patient = findAndMapPatient(patientId);
			List<CertificateResponse> certificates = findCustomerPatientCertificates(patientId, customerId);
			return new SearchCertificateResponse(patient, certificates);
		} catch (PersistenceException e) {
			LOGGER.severe("Error searching certificates for patient with id " + patientId + " - " + e);
			throw new ServiceException("Ocurrio un error en la búsqueda");
		}
	}

	private PatientResponse findAndMapPatient(String patientId) throws ServiceException, PersistenceException {
		Patient patient = patientRepository.findOne(patientId);
		if (patient == null) {
			throw new ServiceException("No hay certificados disponibles para el paciente '" + patientId + "'");
		}
		return new PatientResponseBuilder()
				.setIdentification(patient.getId())
				.setName(patient.getName())
				.build();
	}

	private List<CertificateResponse> findAllPatientCertificates(String patientId) throws PersistenceException {
		List<Certificate> certificates = certificateRepository.findAllByPatientId(patientId);
		if (certificates.isEmpty()) {
			throw new ServiceException("No hay certificados disponibles para el paciente '" + patientId + "'");
		}
		return mapToCertificatesResponse(certificates);
	}

	private List<CertificateResponse> findCustomerPatientCertificates(String patientId, String customerId) throws PersistenceException {
		List<Certificate> certificates = certificateRepository.findAllByPatientIdAndCustomerId(patientId, customerId);
		if (certificates.isEmpty()) {
			throw new ServiceException("No hay certificados disponibles para el paciente '" + patientId + "'");
		}
		return mapToCertificatesResponse(certificates);
	}
	
	private List<CertificateResponse> mapToCertificatesResponse(List<Certificate> certificates) {
		return certificates.stream()
				.map(certificate -> new CertificateResponse(String.valueOf(certificate.getId()), certificate.getName()))
				.collect(Collectors.toList());
	}

}

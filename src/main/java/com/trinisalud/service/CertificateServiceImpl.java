package com.trinisalud.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
			List<CertificateResponse> certificates = findAndMapCertificates(patientId);
			return new SearchCertificateResponse(patient, certificates);
		} catch (PersistenceException e) {
			LOGGER.severe("Error searching certificates for patient with id " + patientId + " - " + e);
			throw new ServiceException("Ocurrio un error en la búsqueda");
		}
	}

	@Override
	public SearchCertificateResponse searchForCustomer(String patientId, String customerId) throws ServiceException {
		try {
			PatientResponse patient = findAndMapPatientForCustomer(patientId, customerId);
			List<CertificateResponse> certificates = findAndMapCertificates(patientId);
			return new SearchCertificateResponse(patient, certificates);
		} catch (PersistenceException e) {
			LOGGER.severe("Error searching certificates for patient with id " + patientId + " - " + e);
			throw new ServiceException("Ocurrio un error en la búsqueda");
		}
	}

	private PatientResponse findAndMapPatient(String patientId) throws ServiceException, PersistenceException {
		Patient patient = patientRepository.findOne(patientId);
		if (patient == null) {
			throw new ServiceException("El paciente con identificacion '" + patientId + "' no fue encontrado");
		}
		return mapToPatientResponse(patient);
	}

	private PatientResponse findAndMapPatientForCustomer(String patientId, String customerId) throws ServiceException, PersistenceException {
		Patient patient = patientRepository.findByIdAndCustomerId(patientId, customerId);
		if (patient == null) {
			throw new ServiceException("El paciente con identificacion '" + patientId + "' no fue encontrado");
		}
		return mapToPatientResponse(patient);
	}

	private List<CertificateResponse> findAndMapCertificates(String patientId) throws PersistenceException {
		List<Certificate> certificates = certificateRepository.findAllByPatientId(patientId);
		return mapToCertificatesResponse(certificates);
	}
	
	private List<CertificateResponse> mapToCertificatesResponse(List<Certificate> certificates) {
		return certificates.stream()
				.map(certificate -> new CertificateResponse(String.valueOf(certificate.getId()), certificate.getName()))
				.collect(Collectors.toList());
	}
	
	private PatientResponse mapToPatientResponse(Patient patient) {
		LocalDate birthdate = patient.getBirthdate().toLocalDate();
		return new PatientResponseBuilder()
				.setIdentification(patient.getId())
				.setName(patient.getName())
				.setBirthdate(DateTimeFormatter.ofPattern("d 'de' MMMM 'de' YYYY").format(birthdate))
				.setAge((int) ChronoUnit.YEARS.between(birthdate, LocalDate.now()))
				.setGender(patient.getGender())
				.setEmail(patient.getEmail())
				.setPhone(patient.getPhone())
				.setAddress(patient.getAddress())
				.setEps(patient.getEps())
				.setCustomerId(patient.getCustomer().getId())
				.build();
	}

}

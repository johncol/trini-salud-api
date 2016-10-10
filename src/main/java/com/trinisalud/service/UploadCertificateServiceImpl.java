package com.trinisalud.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trinisalud.domain.Certificate;
import com.trinisalud.domain.Customer;
import com.trinisalud.domain.Patient;
import com.trinisalud.model.certificate.upload.PatientData;
import com.trinisalud.model.certificate.upload.UploadCertificateRequest;
import com.trinisalud.model.certificate.upload.UploadCertificateResponse;
import com.trinisalud.repository.CertificateRepository;
import com.trinisalud.repository.CustomerRepository;
import com.trinisalud.repository.PatientRepository;

@Component("uploadCertificateService")
public class UploadCertificateServiceImpl implements UploadCertificateService {

	private static final Logger LOGGER = Logger.getLogger(UploadCertificateServiceImpl.class.getName());

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CertificateRepository certificateRepository;

	@Override
	public UploadCertificateResponse upload(UploadCertificateRequest request) throws ServiceException {
		try {
			Patient patient = managePatient(request);
			Certificate certificate = createAndGetCertificate(request, patient);
			return new UploadCertificateResponse(String.valueOf(certificate.getId()), certificate.getName());
		} catch (PersistenceException e) {
			LOGGER.severe("Error uploading certificate " + request + " - " + e);
			throw new ServiceException("No fue posible guardar los datos del paciente y su certificado");
		}
	}
	
	private Patient managePatient(UploadCertificateRequest request) throws PersistenceException, ServiceException {
		String identification = request.getPatient().getIdentification();
		Patient patient = patientRepository.findOne(identification);
		if (patient != null) {
			return patient;
		} else if (request.getPatient().getName() == null) {
			throw new ServiceException("No existen datos del paciente '" + identification + "'");
		}
		return createAndGetPatient(request);
	}

	private Patient createAndGetPatient(UploadCertificateRequest request) throws PersistenceException, ServiceException {
		Customer customer = loadCustomer(request);
		Patient patient = mapToPatient(request.getPatient(), customer);
		patientRepository.save(patient);
		return patient;
	}

	private Customer loadCustomer(UploadCertificateRequest request) throws PersistenceException, ServiceException {
		Customer customer = customerRepository.findOne(request.getCustomer());
		if (customer == null) {
			throw new ServiceException("El cliente no fue encontrado");
		}
		return customer;
	}

	private Certificate createAndGetCertificate(UploadCertificateRequest request, Patient patient) throws PersistenceException {
		String name = request.getCertificate().getName();
		String file = request.getCertificate().getFile();
		Date date = Date.valueOf(LocalDate.now());
		Certificate certificate = new Certificate(name, date, Base64.decodeBase64(file), patient);
		return certificateRepository.save(certificate);
	}

	private Patient mapToPatient(PatientData patient, Customer customer) {
		Date birthdate = Date.valueOf(patient.getBirthdate());
		return new Patient(patient.getIdentification(), patient.getName(), patient.getEmail(), patient.getGender(),
				patient.getEps(), birthdate, patient.getAddress(), patient.getPhone(), customer);
	}

}

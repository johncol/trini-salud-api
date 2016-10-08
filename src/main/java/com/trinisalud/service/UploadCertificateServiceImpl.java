package com.trinisalud.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

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
		Patient patient = managePatient(request);
		Certificate certificate = createAndGetCertificate(request, patient);
		return new UploadCertificateResponse(certificate.getId(), certificate.getName());
	}

	private Patient managePatient(UploadCertificateRequest request) {
		Patient patient = patientRepository.findOne(request.getPatient().getIdentification());
		if (patient != null) {
			return patient;
		}
		return createAndGetPatient(request);
	}

	private Patient createAndGetPatient(UploadCertificateRequest request) {
		Customer customer = loadCustomer(request);
		Patient patient = mapToPatient(request.getPatient(), customer);
		createPatient(patient);
		return patient;
	}

	private Customer loadCustomer(UploadCertificateRequest request) {
		Customer customer = customerRepository.findOne(request.getCustomer());
		if (customer == null) {
			throw new ServiceException("El cliente no fue encontrado");
		}
		return customer;
	}

	private void createPatient(Patient patient) {
		try {
			patientRepository.save(patient);
		} catch (PersistenceException e) {
			LOGGER.severe("Error saving patient " + patient + " - " + e);
			throw new ServiceException("No fue posible guardar los datos del paciente");
		}
	}

	private Certificate createAndGetCertificate(UploadCertificateRequest request, Patient patient) {
		String name = request.getCertificate().getName();
		Date date = Date.valueOf(LocalDate.now());
		Certificate certificate = new Certificate(name, date, null, patient);
		try {
			return certificateRepository.save(certificate);
		} catch (PersistenceException e) {
			LOGGER.severe("Error saving certificate " + certificate + " - " + e);
			throw new ServiceException("No fue posible guardar los datos del certificado");
		}
	}

	private Patient mapToPatient(PatientData patient, Customer customer) {
		Date birthdate = Date.valueOf(patient.getBirthdate());
		return new Patient(patient.getIdentification(), patient.getName(), patient.getEmail(), patient.getGender(),
				patient.getEps(), birthdate, patient.getAddress(), patient.getPhone(), customer);
	}

}

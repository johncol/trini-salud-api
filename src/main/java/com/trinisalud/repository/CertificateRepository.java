package com.trinisalud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.Certificate;

public interface CertificateRepository extends CrudRepository<Certificate, Long> {

	List<Certificate> findAllByPatientId(String patientId);
	
	List<Certificate> findAllByPatientIdAndCustomerId(String patientId, String customerId);

}

package com.trinisalud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.Certificate;

public interface CertificateRepository extends CrudRepository<Certificate, Integer> {

	List<Certificate> findAllByPatientId(String patientId);

}

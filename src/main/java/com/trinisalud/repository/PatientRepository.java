package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, String> {
}

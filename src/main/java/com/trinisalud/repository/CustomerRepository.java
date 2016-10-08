package com.trinisalud.repository;

import org.springframework.data.repository.CrudRepository;

import com.trinisalud.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> { }

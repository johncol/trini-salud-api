package com.trinisalud.service;

import java.util.List;

import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.Customer;

public interface CustomerService {
	
	void create(CreateCustomerRequest request);
	
	List<Customer> list();

}

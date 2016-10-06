package com.trinisalud.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.Customer;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void create(CreateCustomerRequest request) {	
	}

	@Override
	public List<Customer> list() {
		return Arrays.asList(
			new Customer("1", "Cocacola"),
			new Customer("2", "Adidas"),
			new Customer("3", "Nike")
		);
	}

}

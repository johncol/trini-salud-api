package com.trinisalud.service;

import java.util.List;

import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.CustomerData;

public interface CustomerService {
	
	void create(CreateCustomerRequest request) throws ServiceException;
	
	List<CustomerData> list() throws ServiceException;

}

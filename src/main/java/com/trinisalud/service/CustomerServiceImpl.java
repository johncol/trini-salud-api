package com.trinisalud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trinisalud.business.Role;
import com.trinisalud.domain.Customer;
import com.trinisalud.domain.User;
import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.CustomerData;
import com.trinisalud.repository.CustomerRepository;
import com.trinisalud.repository.UserRepository;

@Component("customerService")
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(CreateCustomerRequest request) throws ServiceException {
		User user = mapToUser(request);
		Customer customer = mapToCustomer(request, user);
		verifyCustomerDoNotExist(customer.getId());
		try {
			userRepository.save(user);
			customerRepository.save(customer);
		} catch (PersistenceException e) {
			LOGGER.severe("Error saving customer " + customer + " - " + e);
			throw new ServiceException("Ocurrio un error al guardar el cliente");
		}
	}

	@Override
	public List<CustomerData> list() throws ServiceException {
		try {
			List<CustomerData> customers = new ArrayList<>();
			customerRepository.findAll().forEach(c -> customers.add(new CustomerData(c.getId(), c.getName())));
			return customers;
		} catch (PersistenceException e) {
			LOGGER.severe("Error listing customers - " + e);
			throw new ServiceException("Ocurrio un error al cosultar los clientes");
		}
	}

	private User mapToUser(CreateCustomerRequest request) {
		return new User(request.getIdentification(), request.getPassword(), Role.CUSTOMER.toString());
	}

	private Customer mapToCustomer(CreateCustomerRequest request, User user) {
		return new Customer(request.getIdentification(), request.getName(), request.getEmail(), request.getPhone(),
				user);
	}

	private void verifyCustomerDoNotExist(String id) {
		try {
			Customer customer = customerRepository.findOne(id);
			if (customer != null) {
				throw new ServiceException("El cliente ya fue registrado anteriormente");
			}
		} catch (PersistenceException e) {
			LOGGER.severe("Error finding customer with id " + id + " - " + e);
		}
	}
}

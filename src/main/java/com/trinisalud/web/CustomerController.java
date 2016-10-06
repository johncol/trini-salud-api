package com.trinisalud.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.Customer;
import com.trinisalud.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("")
	public ApiResponse<Object> create(CreateCustomerRequest request) {
		LOGGER.info("create request: " + request);
		customerService.create(request);
		return new ApiResponse<Object>(true, "Ok");
	}
	
	@GetMapping("")
	public ApiResponse<List<Customer>> list() {
		LOGGER.info("list request");
		return new ApiResponse<List<Customer>>(true, "Ok", customerService.list());
	}

}

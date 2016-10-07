package com.trinisalud.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trinisalud.model.customer.CreateCustomerRequest;
import com.trinisalud.model.customer.CustomerData;
import com.trinisalud.service.CustomerService;
import com.trinisalud.service.ServiceException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	@Autowired
	private CustomerService customerService;

	@PostMapping("")
	public ApiResponse<Object> create(@RequestBody CreateCustomerRequest request) {
		LOGGER.info("create request: " + request);
		try {
			customerService.create(request);
			return new ApiResponse<Object>(true, "Ok");
		} catch (ServiceException e) {
			return new ApiResponse<Object>(false, e.getMessage());
		}
	}

	@GetMapping("")
	public ApiResponse<List<CustomerData>> list() {
		LOGGER.info("list request");
		try {
			List<CustomerData> customers = customerService.list();
			return new ApiResponse<List<CustomerData>>(true, "Ok", customers);
		} catch (ServiceException e) {
			return new ApiResponse<List<CustomerData>>(false, e.getMessage());
		}
	}

}

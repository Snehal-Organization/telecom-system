package com.telecom.customer_service.service;

import java.util.List;
import java.util.Optional;

import com.telecom.customer_service.dto.CustomerDTO;

public interface CustomerService {
	
	Optional<CustomerDTO> getCustomerById(Long id);

	CustomerDTO createCustomer(CustomerDTO customerDTO);

	List<CustomerDTO> getAllCustomers();

	CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

	void deleteCustomer(Long id);
}

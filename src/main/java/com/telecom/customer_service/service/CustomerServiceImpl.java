package com.telecom.customer_service.service;

import com.telecom.customer_service.dto.CustomerDTO;
import com.telecom.customer_service.entity.CustomerEntity;
import com.telecom.customer_service.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
		CustomerEntity saved = customerRepository.save(customerEntity);
		return modelMapper.map(saved, CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<CustomerDTO> getCustomerById(Long id) {
		return customerRepository.findById(id).map(entity -> modelMapper.map(entity, CustomerDTO.class));
	}

	@Override
	public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
		customerDTO.setId(id);
		CustomerEntity updated = modelMapper.map(customerDTO, CustomerEntity.class);
		CustomerEntity saved = customerRepository.save(updated);
		return modelMapper.map(saved, CustomerDTO.class);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}

package com.telecom.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.customer_service.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}

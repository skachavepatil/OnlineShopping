package com.ex.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ex.messagelistener.CustomerMessageListener;
import com.ex.model.Customer;
import com.ex.repository.CustomerSalesOrderRepository;

@Service
public class CustomerService {

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Autowired
	private CustomerSalesOrderRepository customerSORepository;

	public Customer save(CustomerMessageListener.Customer customer) {
		return customerSORepository.save(modelMapper().map(customer, Customer.class));
	}
}

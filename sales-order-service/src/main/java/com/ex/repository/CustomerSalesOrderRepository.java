package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.model.Customer;

public interface CustomerSalesOrderRepository extends JpaRepository<Customer, Long>{

}

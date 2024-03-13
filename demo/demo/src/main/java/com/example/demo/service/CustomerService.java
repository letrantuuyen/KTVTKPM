package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
@Service

public interface CustomerService  {

	public Customer findCustomerById(String id);
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer customeradd);
	public String delete(String id);
}

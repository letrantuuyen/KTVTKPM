package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;


@Repository
public interface CustomerDao {
	
	public Customer findCustomerById(String id);
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer customeradd);
	public String delete(String id);

}

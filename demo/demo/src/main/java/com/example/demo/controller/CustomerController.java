package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	 @PostMapping("/save")
	    public Customer save(@RequestBody Customer customer) {
	        return customerService.addCustomer(customer);
	    }
	 @GetMapping("/findAll")
	    public List<Customer> getAllCustomer() {
	        return customerService.getAllCustomer();
	    }
	 @GetMapping("findCustomerById/{id}")
	 public Customer findCustomerById(@PathVariable String id) {
		 return customerService.findCustomerById(id);
	 }
	 
	 @DeleteMapping("delete/{id}")
	 public String delete (@PathVariable String id) {
		 return customerService.delete(id);
	 }
	

}

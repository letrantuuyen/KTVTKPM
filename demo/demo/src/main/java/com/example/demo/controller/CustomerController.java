package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.JwtService;

import io.jsonwebtoken.Jwts;



@RestController
@RequestMapping("/customer")
@EnableCaching
@ComponentScan(basePackages = {"com.example.demo.entity"})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/login")
    public String login(@RequestBody User user) {
        // Validate user credentials
        User foundUser = userDao.findUserByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            // If credentials are valid, generate and return JWT
            return jwtService.generateToken(user.getEmail());
        } else {
            // If credentials are not valid, return error message
            return "Invalid email or password";
        }
    }
	
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

package Week4_Redis.Week4_Redis_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Week4_Redis.Week4_Redis_Entity.Customer;
import Week4_Redis.Week4_Redis_Service.CustomerService;

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
	

}

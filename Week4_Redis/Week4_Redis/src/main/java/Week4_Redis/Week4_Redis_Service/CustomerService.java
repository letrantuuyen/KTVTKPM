package Week4_Redis.Week4_Redis_Service;

import java.util.List;

import Week4_Redis.Week4_Redis_Entity.Customer;

public interface CustomerService {

	public Customer findCustomerById(String id);
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer customeradd);
	public String delete(String id);
}

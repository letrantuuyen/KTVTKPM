package Week4_Redis.Week4_Redis_Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Week4_Redis.Week4_Redis_Entity.Customer;
@Repository
public interface CustomerDao {
	
	public Customer findCustomerById(String id);
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer customeradd);
	public String delete(String id);

}

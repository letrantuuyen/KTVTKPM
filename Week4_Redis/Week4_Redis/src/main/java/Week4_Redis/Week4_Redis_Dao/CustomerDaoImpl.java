package Week4_Redis.Week4_Redis_Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Week4_Redis.Week4_Redis_Entity.Customer;


/**
 * @author LENOVO
 *
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	
	 public static final String HASH_KEY = "Customer";
	
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public Customer findCustomerById(String id) {
		return (Customer) redisTemplate.opsForValue().get(HASH_KEY);
	
	}

	@Override
	public List<Customer> getAllCustomer() {
		return redisTemplate.opsForHash().values(HASH_KEY);
		
	}
	 public Customer addCustomer(Customer customer) {
	        redisTemplate.opsForHash().put(HASH_KEY,  customer.getCustomerId(), customer);
	        return customer;
	    }

	@Override
	public String delete(String id) {
		redisTemplate.opsForHash().delete(HASH_KEY,id);
		return "complete delete customer";
	}

}

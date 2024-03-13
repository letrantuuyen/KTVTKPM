package com.example.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDao {

	private static final String HASH_KEY = "User";
	@Autowired
	private RedisTemplate template;

	public User save(User user) {
		template.opsForHash().put(HASH_KEY, user.getId(), user);
		return user;
	}

	public List<User> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public User findUserById(int id) {
		System.out.println("called findProductById() from DB");
		return (User) template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteUser(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "User removed !!";
	}
	public User findUserByEmail(String email) {
        Collection<User> users = template.opsForHash().values(HASH_KEY);
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash()
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
	
	@Id
	private int id;
	private String user_name;
	private String password;
	private String email;
	
	
}

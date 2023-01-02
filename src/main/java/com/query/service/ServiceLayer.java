package com.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.bean.UserDetails;
import com.query.repo.Repo;

@Service
public class ServiceLayer {
	@Autowired
	Repo repo;
	
	public UserDetails addUser(UserDetails detail) {
		return repo.save(detail);
	}
}

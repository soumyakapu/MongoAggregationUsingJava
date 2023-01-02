package com.query.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.query.bean.Dummy;
import com.query.bean.UserDetails;

public interface Repo extends MongoRepository<UserDetails, Integer> {

	
	
	
}

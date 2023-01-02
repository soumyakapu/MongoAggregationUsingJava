package com.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.query.bean.Dummy;
import com.query.repo.DummyRepo;
import com.query.repo.Repo;

@Service
public class DummyService {
	
	@Autowired
	DummyRepo dummyRepo;
	
	@Autowired
	Repo repo;
	public List<Dummy> getProductivity(String userid) {
		return dummyRepo.findAggregateByUser(userid);
	}
	
	
	  
	 	
}

package com.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.query.bean.Dummy;
import com.query.bean.UserDetails;
import com.query.service.DummyService;
import com.query.service.ServiceLayer;

@RestController
public class controller {
	@Autowired
	ServiceLayer service;
	
	@Autowired
	DummyService dummyService;
	
	
	//for getting the details from themongodb
	@GetMapping("/get/{userid}")
	public List<Dummy> getProductivity(@PathVariable("userid") String userid) {
		return dummyService.getProductivity(userid);
	}
	
	//for posting the users by postman
	@PostMapping("/add")
	public UserDetails addUser(@RequestBody UserDetails details) {
		return service.addUser(details);
	}
}

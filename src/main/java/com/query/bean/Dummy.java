package com.query.bean;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="Dummy")
public class Dummy {
	
	@Id
	private String id;
	private long totalUserDuration;
	private List<Year> user;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public long getTotalUserDuration() {
		return totalUserDuration;
	}
	public void setTotalUserDuration(long totalUserDuration) {
		this.totalUserDuration = totalUserDuration;
	}
	public List<Year> getUser() {
		return user;
	}
	public void setUser(List<Year> user) {
		this.user = user;
	}
	
}

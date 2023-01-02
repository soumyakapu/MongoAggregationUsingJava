package com.query.bean;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Dummy")
public class UserDetails {
	private int id;
	private String user;
	private long startTime;
	private long endTime;
	private String Date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
}

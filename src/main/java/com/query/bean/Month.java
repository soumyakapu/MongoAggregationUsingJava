package com.query.bean;

import java.util.List;

public class Month {
	private String month;
	private long totalMonthsWorkedHours;
	private List<Day> days;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public long getTotalMonthsWorkedHours() {
		return totalMonthsWorkedHours;
	}
	public void setTotalMonthsWorkedHours(long totalMonthsWorkedHours) {
		this.totalMonthsWorkedHours = totalMonthsWorkedHours;
	}
	public List<Day> getDay() {
		return days;
	}
	public void setDay(List<Day> day) {
		this.days = day;
	}
	@Override
	public String toString() {
		return "Month [month=" + month + ", totalMonthsWorkedHours=" + totalMonthsWorkedHours + ", day=" + days + "]";
	}
	
	
}

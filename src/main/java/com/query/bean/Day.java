package com.query.bean;

public class Day {
	private String day;
	private long totalDaysWorkedHours;
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public long getTotalDaysWorkedHours() {
		return totalDaysWorkedHours;
	}

	public void setTotalDaysWorkedHours(long totalDaysWorkedHours) {
		this.totalDaysWorkedHours = totalDaysWorkedHours;
	}

	@Override
	public String toString() {
		return "Day [Day=" + day + ", totalDaysWorkedHours=" + totalDaysWorkedHours + "]";
	}
	
}

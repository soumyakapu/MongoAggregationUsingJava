package com.query.bean;

import java.util.List;

public class Year {
	private String year;
	private long totalYearWorkedHours;
	private List<Month> months;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public long getTotalYearWorkedHours() {
		return totalYearWorkedHours;
	}
	public void setTotalYearWorkedHours(long totalYearWorkedHours) {
		this.totalYearWorkedHours = totalYearWorkedHours;
	}
	public List<Month> getMonths() {
		return months;
	}
	public void setMonths(List<Month> months) {
		this.months = months;
	}
	@Override
	public String toString() {
		return "Year [year=" + year + ", totalYearWorkedHours=" + totalYearWorkedHours + ", months=" + months + "]";
	}
	
}

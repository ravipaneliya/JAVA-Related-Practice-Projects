package com.flyaway.model;

public class FlightDetails {
	private int id;
	private int flight_number;
	private String airline;
	private String weekdays;
	private String src_airport_code;
	private String dest_airport_code;
	private double economy_fare;
	private double premium_fare;
	private double business_fare;
	
	public FlightDetails() {}
	
	public FlightDetails(int flight_number, String airline, String weekdays, String src_airport_code,
			String dest_airport_code, double economy_fare, double premium_fare, double business_fare) {
		super();
		this.flight_number = flight_number;
		this.airline = airline;
		this.weekdays = weekdays;
		this.src_airport_code = src_airport_code;
		this.dest_airport_code = dest_airport_code;
		this.economy_fare = economy_fare;
		this.premium_fare = premium_fare;
		this.business_fare = business_fare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}
	public String getSrc_airport_code() {
		return src_airport_code;
	}
	public void setSrc_airport_code(String src_airport_code) {
		this.src_airport_code = src_airport_code;
	}
	public String getDest_airport_code() {
		return dest_airport_code;
	}
	public void setDest_airport_code(String dest_airport_code) {
		this.dest_airport_code = dest_airport_code;
	}
	public double getEconomy_fare() {
		return economy_fare;
	}
	public void setEconomy_fare(double economy_fare) {
		this.economy_fare = economy_fare;
	}
	public double getPremium_fare() {
		return premium_fare;
	}
	public void setPremium_fare(double premium_fare) {
		this.premium_fare = premium_fare;
	}
	public double getBusiness_fare() {
		return business_fare;
	}
	public void setBusiness_fare(double business_fare) {
		this.business_fare = business_fare;
	}
}

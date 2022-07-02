package com.flyaway.model;

import java.util.Date;

public class BookingDetails {
	private int id;
	private int flight_id;
	private String booking_class;
	private Date travel_date;
	private int no_of_passanger;
	private double total_fare;
	private int booking_status;
	private int customer_id;
	
	public BookingDetails() {}
	
	public BookingDetails(int flight_id, String booking_class, Date travel_date, int no_of_passanger, double total_fare,
			int booking_status, int customer_id) {
		super();
		this.flight_id = flight_id;
		this.booking_class = booking_class;
		this.travel_date = travel_date;
		this.no_of_passanger = no_of_passanger;
		this.total_fare = total_fare;
		this.booking_status = booking_status;
		this.customer_id = customer_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getBooking_class() {
		return booking_class;
	}
	public void setBooking_class(String booking_class) {
		this.booking_class = booking_class;
	}
	public Date getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}
	public int getNo_of_passanger() {
		return no_of_passanger;
	}
	public void setNo_of_passanger(int no_of_passanger) {
		this.no_of_passanger = no_of_passanger;
	}
	public double getTotal_fare() {
		return total_fare;
	}
	public void setTotal_fare(double total_fare) {
		this.total_fare = total_fare;
	}
	public int getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(int booking_status) {
		this.booking_status = booking_status;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
}

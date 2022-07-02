package com.flyaway.model;

public class Ticket {
	private int bookingID;
	private String customerName;
	private String phoneNo;
	private String bookingClass;
	private String travelDate;
	private String bookingDate;
	private int travellers;
	private double totalFare;
	
	public Ticket() {}
	
	public Ticket(int bookingID, String customerName, String phoneNo, String bookingClass, String travelDate,
			String bookingDate, int travellers, double totalFare) {
		super();
		this.bookingID = bookingID;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.bookingClass = bookingClass;
		this.travelDate = travelDate;
		this.bookingDate = bookingDate;
		this.travellers = travellers;
		this.totalFare = totalFare;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getBookingClass() {
		return bookingClass;
	}
	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTravellers() {
		return travellers;
	}
	public void setTravellers(int travellers) {
		this.travellers = travellers;
	}
	public double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
}

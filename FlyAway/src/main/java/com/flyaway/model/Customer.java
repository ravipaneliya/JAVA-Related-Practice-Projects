package com.flyaway.model;

public class Customer {

	private int id;
	private String name;
	private int is_admin;
	private String email;
	private String password_string;
	private String phoneno;
	
	public Customer() {	}

	public Customer(String name, int is_admin, String email, String password_string, String phoneno) {
		super();
		this.name = name;
		this.is_admin = is_admin;
		this.email = email;
		this.password_string = password_string;
		this.phoneno = phoneno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getPassword_string() {
		return password_string;
	}

	public void setPassword_string(String password_string) {
		this.password_string = password_string;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
}

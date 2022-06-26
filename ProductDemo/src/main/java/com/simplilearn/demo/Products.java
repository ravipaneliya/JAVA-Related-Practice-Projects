package com.simplilearn.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "products")
public class Products {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generation
	@Column(name = "pid") // if the column name is different then the field name
	private int id;

	@Column(name = "prodname")
	private String name;

	@ColumnDefault("0.0")
	private double price;

	@ColumnDefault("NULL")
	private String description;

	public Products() {
	}

	public Products(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

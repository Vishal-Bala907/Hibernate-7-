package com.common.annotations;

import java.util.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50, name = "STREET")
	private String street;

	@Column(length = 50, name = "CITY", unique = true)
	private String city;

	@Column(name = "IS_OPEN")
	private boolean isOpen;
	
	@Transient
	private double x;
	
	@SuppressWarnings("deprecation")
	@Temporal(TemporalType.DATE)
	private Date date;
	
//	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String street, String city, boolean isOpen, double x, Date date, byte[] image) {
		super();
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.date = date;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x=" + x
				+ ", date=" + date + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}

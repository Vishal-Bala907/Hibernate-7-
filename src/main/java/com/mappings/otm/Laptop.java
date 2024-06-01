package com.mappings.otm;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int laptopId;
	private String laptopName;
	
	@ManyToOne
	private LaptopOwner laptopOwner;

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String laptopName, LaptopOwner laptopOwner) {
		super();
		this.laptopName = laptopName;
		this.laptopOwner = laptopOwner;
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public LaptopOwner getPerson() {
		return laptopOwner;
	}

	public void setPerson(LaptopOwner laptopOwner) {
		this.laptopOwner = laptopOwner;
	}
	
}

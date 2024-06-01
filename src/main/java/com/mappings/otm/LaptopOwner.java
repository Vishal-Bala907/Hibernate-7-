package com.mappings.otm;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LaptopOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String PersonName;
	
	@OneToMany(mappedBy = "laptopOwner",fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private List<Laptop> laptops;

	public LaptopOwner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LaptopOwner(String personName, List<Laptop> laptops) {
		super();
		PersonName = personName;
		this.laptops = laptops;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	
	
	
	
}

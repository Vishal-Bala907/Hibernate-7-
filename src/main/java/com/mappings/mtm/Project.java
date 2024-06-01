package com.mappings.mtm;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PiD;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	@Cascade(CascadeType.ALL)
	private List<Employee> employees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectName, List<Employee> employees) {
		super();
		this.projectName = projectName;
		this.employees = employees;
	}

	public int getPiD() {
		return PiD;
	}

	public void setPiD(int piD) {
		PiD = piD;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}

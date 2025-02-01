package com.orm.mapping;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@Column(name = "project_id")
	private int projectId; 
	
	@Column(name = "project_name")
	private String projectName;
	
	@ManyToMany(mappedBy= "projects", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// This fetch type LAZY is applied for accessing getters on Project class object
	
	private List<Employee> emps;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, List<Employee> emps) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.emps = emps;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}

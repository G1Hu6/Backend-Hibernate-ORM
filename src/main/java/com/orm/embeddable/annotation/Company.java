package com.orm.embeddable.annotation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	private int id;
	
	@Column(name = "company_name")
	private String name;
	
	// another class Technology is embedded here
	private Technology tech;
	

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, Technology tech) {
		super();
		this.id = id;
		this.name = name;
		this.tech = tech;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", tech=" + tech + "]";
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

	public Technology getTech() {
		return tech;
	}

	public void setTech(Technology tech) {
		this.tech = tech;
	}
	
}

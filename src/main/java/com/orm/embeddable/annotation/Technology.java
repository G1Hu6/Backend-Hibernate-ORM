package com.orm.embeddable.annotation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Technology {
	
	@Column(name = "technology_name")
	private String name;
	
	@Column(name = "technology_framework")
	private String framework;

	public Technology() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technology(String name, String framework) {
		super();
		this.name = name;
		this.framework = framework;
	}

	@Override
	public String toString() {
		return "Technology [name=" + name + ", framework=" + framework + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}
	
}

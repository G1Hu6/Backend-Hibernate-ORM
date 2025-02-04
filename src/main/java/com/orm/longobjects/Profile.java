package com.orm.longobjects;

import java.util.Date;

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
@Table(name="student_profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_id")
	private int profileId;
	
	@Column(name="student_name", length=50)
	private String name;
	
	@Column(length = 200, name="profile_description")
	private String description;
	
	@Column(name="ACTIVATED")
	private boolean isActivated;
	
	@Transient
	private boolean isAuthorised;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] profileImage;
	
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@Override
//	public String toString() {
//		return name + " : " + description;
//	}

	public Profile(int profileId, String name, String description, boolean isActivated, boolean isAuthorised, Date date,
			byte[] profileImage) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.description = description;
		this.isActivated = isActivated;
		this.isAuthorised = isAuthorised;
		this.date = date;
		this.profileImage = profileImage;
	}


	public int getProfileId() {
		return profileId;
	}


	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isActivated() {
		return isActivated;
	}


	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}


	public boolean isAuthorised() {
		return isAuthorised;
	}


	public void setAuthorised(boolean isAuthorised) {
		this.isAuthorised = isAuthorised;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public byte[] getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
	
}

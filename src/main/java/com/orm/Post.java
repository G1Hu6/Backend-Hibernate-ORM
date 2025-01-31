package com.orm;

/*import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;*/

/*import jakarta.persistence.Cacheable;*/
import jakarta.persistence.Entity;
/*import jakarta.persistence.Table;*/
import jakarta.persistence.Id;

@Entity
/*
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
*/
public class Post {
	
	@Id
	private int id;
	
	private String userName;
	
	private int followersNo;
	
	private String caption;
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", userName=" + userName + ", followersNo=" + followersNo + ", caption=" + caption
				+ "]";
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Post(int id, String userName, int followersNo, String caption) {
		super();
		this.id = id;
		this.userName = userName;
		this.followersNo = followersNo;
		this.caption = caption;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getFollowersNo() {
		return followersNo;
	}
	
	public void setFollowersNo(int followersNo) {
		this.followersNo = followersNo;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}

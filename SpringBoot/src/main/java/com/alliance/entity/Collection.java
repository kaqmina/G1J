package com.alliance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collection")
public class Collection {
	
	@Id
	@Column(name = "collectionId")
	private int collectionId;

	@Column(name = "name")
	private String name;

	@Column(name = "userId")
	private int userId;
	
	@Column(name = "isArchived")
	private int isArchived;
	

	public Collection() {}
	
	public int getId() {
		return this.collectionId;
	}
	
	public void setId(int collectionId) {
		this.collectionId = collectionId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getIsArchived() {
		return this.isArchived;
	}
	
	public void setIsArchived(int isArchived) {
		this.isArchived = isArchived;
	}
}

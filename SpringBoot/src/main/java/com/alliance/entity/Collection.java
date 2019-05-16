package com.alliance.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "collection")
public class Collection {
	
	@Id
	private int collectionId;
	private String name;
	private int userId;
	private int isArchived;
	
	@Column(name = "collectionId")
	public int getId() {
		return this.collectionId;
	}
	
	@Column(name = "isArchived")
	public int getIsArchived() {
		return this.isArchived;
	}
	
	public void setIsArchived(int isArchived) {
		this.isArchived = isArchived;
	}
	
	public Collection() {}
	
	public void setId(int cardId) {
		this.collectionId = cardId;
	}
	
	@Column(name = "name")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "user")
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}

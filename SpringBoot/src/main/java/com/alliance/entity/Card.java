package com.alliance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	private int cardId;
	private String heading;
	private String desc;	// description
	private int collectionId;
	private int isArchived;
	
	public Card() {}
	
	@Column(name = "isArchived")
	public int getIsArchived() {
		return this.isArchived;
	}
	
	public void setIsArchived(int isArchived) {
		this.isArchived = isArchived;
	}
	
	@Column(name = "cardId")
	public int getId() {
		return this.cardId;
	}
	
	public void setId(int cardId) {
		this.cardId = cardId;
	}
	
	@Column(name = "heading")
	public String getHeading() {
		return this.heading;
	}
	
	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	@Column(name = "desc")
	public String getDesc() {
		return this.desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "collectionId")
	public int getCollectionId() {
		return this.collectionId;
	}
	
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
}

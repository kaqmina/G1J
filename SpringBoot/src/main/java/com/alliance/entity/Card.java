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
	@Column(name = "cardId")
	private int cardId;

	@Column(name = "heading")
	private String heading;

	@Column(name = "description")
	private String desc;	// description

	@Column(name = "collectionId")
	private int collectionId;
	
	@Column(name = "isArchived")
	private int isArchived;
	
	public Card() {}
	
	public int getIsArchived() {
		return this.isArchived;
	}
	
	public void setIsArchived(int isArchived) {
		this.isArchived = isArchived;
	}
	
	public int getId() {
		return this.cardId;
	}
	
	public void setId(int cardId) {
		this.cardId = cardId;
	}
	
	public String getHeading() {
		return this.heading;
	}
	
	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getCollectionId() {
		return this.collectionId;
	}
	
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
}

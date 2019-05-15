package com.alliance.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	private int cardId;
	private String heading;
	private String desc;	// description
	private int collectionId;
	
	public Card() {}
	
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

package com.alliance.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private int userId;
	private String username;
	private String password;
	
	
	public int getId() {
		return this.userId;
	}
	
	public void setId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String username) {
		this.username = username; 
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

package com.revature.voteappboot.classes;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class User {
	@Id
	private String username;
	private String password;
	
	public User() {
		username = "";
		password = "";
	}
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
}

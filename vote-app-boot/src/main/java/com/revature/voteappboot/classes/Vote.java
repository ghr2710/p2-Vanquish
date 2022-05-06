package com.revature.voteappboot.classes;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Vote {

	private String username;
	private int postId;
	
	
	
public Vote() {
	username = "";
	postId = 0;
}



public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getPostId() {
	return postId;
}

public void setPostId(int postId) {
	this.postId = postId;
}



@Override
public String toString() {
	return "Votes [username=" + username + ", postId=" + postId + "]";
}


}

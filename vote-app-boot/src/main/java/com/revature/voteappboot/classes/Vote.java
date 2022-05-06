package com.revature.voteappboot.classes;

import javax.persistence.*;

@Entity
@Table(name = "votes")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int voteid;
	private String username;
	private int postid;
	
	public Vote() {
		username = "";
		postid = 0;
	}

	public int getVoteId() {
		return voteid;
	}

	public void setVoteId(int id) {
		this.voteid = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPostId() {
		return postid;
	}

	public void setPostId(int postId) {
		this.postid = postId;
	}

	@Override
	public String toString() {
		return "Votes [username=" + username + ", postId=" + postid + "]";
	}


}

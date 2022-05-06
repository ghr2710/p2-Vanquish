package com.revature.voteappboot.classes;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Table

public class Comment {
	@Id
	private int commentid;
	@Column
	private int postid;
	@Column
	private String username;
	@Column
	private String commentbody;
	@Column
	private Date datePosted;
	
	
	public Comment() {
		commentid = 0;
		postid = 0;
		username = "";
		commentbody = "";
		datePosted = new Date();
		
	}

	public Comment(int id, int rel, String username, String body, Date day) {
		commentid = id;
		postid = rel;
		this.username = username;
		commentbody = body;
		datePosted = day;
		
	}
	
	public int getCommentId() {
		return commentid;
	}
	public void setCommentId(int commentId) {
		this.commentid = commentId;
	}
	public int getRelatedPost() {
		return postid;
	}
	public void setRelatedPost(int relatedPost) {
		this.postid = relatedPost;
	}
	public String getCommentBody() {
		return commentbody;
	}
	public void setCommentBody(String commentBody) {
		this.commentbody = commentBody;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public java.sql.Date sqlDate() {
		return new java.sql.Date(datePosted.getTime());
	}
	public String getStringDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(datePosted); 
		return strDate;
	}



}

package dev.khayman;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {
	private int commentId;
	private int relatedPost;
	private String username;
	private String commentBody;
	private Date datePosted;
	
	
	public Comments() {
		commentId = 0;
		relatedPost = 0;
		username = "";
		commentBody = "";
		datePosted = new Date();
		
	}

	public Comments(int id, int rel, String username, String body, Date day) {
		commentId = id;
		relatedPost = rel;
		this.username = username;
		commentBody = body;
		datePosted = day;
		
	}
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getRelatedPost() {
		return relatedPost;
	}
	public void setRelatedPost(int relatedPost) {
		this.relatedPost = relatedPost;
	}
	public String getCommentBody() {
		return commentBody;
	}
	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
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

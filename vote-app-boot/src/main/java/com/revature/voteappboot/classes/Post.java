package com.revature.voteappboot.classes;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
@Entity
@Table
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	private String username;
	private Date datePosted;
	private String postBody;
	private String option1;
	private String option2;
	private int numberOfVotesOption1;
	private int numberOfVotesOption2;
	private int totalVotes;
	
	public Post() {
		postId = 0;
		username = "";
		datePosted = new Date();
		postBody = "";
		option1 = "";
		option2 = "";
		numberOfVotesOption1 = 0;
		numberOfVotesOption2 = 0;
		totalVotes = 0;
	}
	
	public Post(int id, String username, Date day, String body, String op1, String op2, int numVotes1, int numVotes2, int total) {
		postId = id;
		this.username = username;
		datePosted = day;
		postBody = body;
		option1 = op1;
		option2 = op2;
		numberOfVotesOption1 = numVotes1;
		numberOfVotesOption2 = numVotes2;
		totalVotes = total;
		
	}
	
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	public String getPostBody() {
		return postBody;
	}
	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public int getNumberOfVotesOption1() {
		return numberOfVotesOption1;
	}
	public void setNumberOfVotesOption1(int numberOfVotesOption1) {
		this.numberOfVotesOption1 = numberOfVotesOption1;
	}
	public int getNumberOfVotesOption2() {
		return numberOfVotesOption2;
	}
	public void setNumberOfVotesOption2(int numberOfVotesOption2) {
		this.numberOfVotesOption2 = numberOfVotesOption2;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
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

package com.revature.voteappboot.classes;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postid;
	private String username;
	private Date datePosted;
	private String postbody;
	private String option1name;
	private String option2name;
	private int option1vote;
	private int option2vote;
	private int totalVotes;
	@OneToMany
	@JoinColumn(name="post_id")
	private List<Comment> comments;
	
	public Post() {
		postid = 0;
		username = "";
		datePosted = new Date();
		postbody = "";
		option1name = "";
		option2name = "";
		option1vote = 0;
		option2vote = 0;
		totalVotes = 0;
		comments = new ArrayList<>();
	}
	
	public Post(int id, String username, Date day, String body, String op1, String op2, int numVotes1, int numVotes2, int total) {
		postid = id;
		this.username = username;
		datePosted = day;
		postbody = body;
		option1name = op1;
		option2name = op2;
		option1vote = numVotes1;
		option2vote = numVotes2;
		totalVotes = total;
		
	}
	
	
	public int getPostId() {
		return postid;
	}
	public void setPostId(int postId) {
		this.postid = postId;
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
		return postbody;
	}
	public void setPostBody(String postBody) {
		this.postbody = postBody;
	}
	public String getOption1() {
		return option1name;
	}
	public void setOption1(String option1) {
		this.option1name = option1;
	}
	public String getOption2() {
		return option2name;
	}
	public void setOption2(String option2) {
		this.option2name = option2;
	}
	public int getNumberOfVotesOption1() {
		return option1vote;
	}
	public void setNumberOfVotesOption1(int numberOfVotesOption1) {
		this.option1vote = numberOfVotesOption1;
	}
	public int getNumberOfVotesOption2() {
		return option2vote;
	}
	public void setNumberOfVotesOption2(int numberOfVotesOption2) {
		this.option2vote = numberOfVotesOption2;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

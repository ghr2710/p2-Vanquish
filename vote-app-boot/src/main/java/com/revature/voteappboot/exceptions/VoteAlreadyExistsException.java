package com.revature.voteappboot.exceptions;

public class VoteAlreadyExistsException extends Exception{
	
	public VoteAlreadyExistsException() {
		super("The user has already voted on this post");
	}

}

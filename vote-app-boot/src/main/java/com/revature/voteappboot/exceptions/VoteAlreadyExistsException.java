package com.revature.voteappboot.exceptions;

public class VoteAlreadyExistsException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public VoteAlreadyExistsException() {
		super("The user has already voted on this post");
	}

}

package com.revature.voteappboot.exceptions;

public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException() {
		super("The username already exists");
	}

}

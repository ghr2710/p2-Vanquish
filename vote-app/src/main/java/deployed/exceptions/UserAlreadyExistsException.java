package deployed.exceptions;

public class UserAlreadyExistsException extends Exception{
	
	public UserAlreadyExistsException() {
		super("The username already exists");
	}

}

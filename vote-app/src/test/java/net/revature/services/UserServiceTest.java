package net.revature.services;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import deployed.classes.User;
import deployed.exceptions.IncorrectCredsException;
import deployed.services.userService;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserDAO userDAO;
	
	@InjectMocks
	userService userServ = new userService();
	
	@Test
	public void logInSuccessfully() throws IncorrectCredsException{
		String username = "TestUser";
		String password = "TestPass";
		
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPassword(password);
		
		when(userDAO.getByUsername(username)).thenReturn(mockUser);
		
		User actualUser = userServ.logIn(username, password);
		
		assertEquals(mockUser, actualUser);
		

}

}

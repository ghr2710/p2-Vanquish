package net.revature.services;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import deployed.classes.User;
import deployed.exceptions.IncorrectCredsException;
import deployed.exceptions.UserAlreadyExistsException;
import deployed.exceptions.UserDoesNotExistException;
import deployed.services.userService;
import dev.chopra.IncorrectCredentialsException;
import dev.chopra.UsernameAlreadyExistsException;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserDAO userDAO;
	
	@InjectMocks
	userService userServ= new userService();
	
	
	public void CreateAcctsuccessfully() throws UserAlreadyExistsException {
		User u = new User();
		
		// mock userDao.create(u)
		when(userDao.create(u)).thenReturn("TestUser");
		
		Boolean result = userServ.createAcct(u);
		
		// returns Username
		assertNotEquals(0, result.getUsername());
	}
	@Test
	public void registerUsernameTaken() {
		User u = new User();
		u.setUsername("kchopr");
		
		// mock userDao.create(newUser)
		when(userDao.create(u)).thenReturn(0);
		
		assertThrows(UserAlreadyExistsException.class, () -> {
			userServ.createAcct(u);
		});
	}
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
	@Test
	public void logInWrongUsername() {
		String username = "abc123";
		String password = "1234567890";
		
		// we need to mock userDao.getByUsername(username)
		when(userDao.getByUsername(username)).thenReturn(null);
		
		assertThrows(IncorrectCredsException.class, () -> {
			// put the code that we're expecting to throw the exception
			userServ.logIn(username, password);
		});
	}

}


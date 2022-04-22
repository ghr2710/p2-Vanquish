package dev.chopra;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.exceptions.IncorrectCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.models.User;

import deployed.classes.*;
import deployed.exceptions.*;
import deployed.services.userService;




@Extendwith(MockitoExtension.class)
public class UserServiceTest {
@Mock
private UserDAO = userDAO;

@InjectMocks
userService userCreated = new userService();
@Test
public void CreateAcctsuccessfully() throws UserAlreadyExistsException {
	User u = new User();
	
	// mock userDao.create(u)
	when(userDao.create(u)).thenReturn(1);
	
	User result = userCreated.CreateAcct(u);
	
	// returns id
	assertNotEquals(0, result.getId());
	
	
}
@Test
public void registerUsernameTaken() {
	User u = new User();
	u.setUsername("kchopr");
	
	// mock userDao.create(newUser)
	when(userDao.create(u)).thenReturn(0);
	
	assertThrows(UsernameAlreadyExistsException.class, () -> {
		userServ.register(u);
	});
}
private void loginSuccessfully() throws IncorrectCredsException{
	String username = "TestUser";
	String password = "TestPass";
	
	User mockUser = new User();
	mockUser.setUsername(username);
	mockUser.setPassword(password);
	when(userDao.getByUsername(username)).thenReturn(mockUser);
	
	User actualUser = userCreated.logIn(username, password);
	
	assertEquals(mockUser, actualUser);
	}


@Test
public void logInWrongUsername() {
	String username = "abc123";
	String password = "1234567890";
	
	// we need to mock userDao.getByUsername(username)
	when(userDao.getByUsername(username)).thenReturn(null);
	
	assertThrows(IncorrectCredentialsException.class, () -> {
		// put the code that we're expecting to throw the exception
		userCreated.logIn(username, password);
	});
}

public void deleteUserSuccessfully() throws UserDoesNotExistException{
	
	
	When(userDAO.deleteUser(username)).thenReturn(username)
	assertDoesNotThrow(() -> {
		userDao.delete(TestUser);
	});

}

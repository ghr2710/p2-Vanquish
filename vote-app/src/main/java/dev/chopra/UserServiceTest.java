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




}

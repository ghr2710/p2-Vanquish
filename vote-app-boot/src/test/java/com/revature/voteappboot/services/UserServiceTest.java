package com.revature.voteappboot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.voteappboot.VoteAppBootApplication;
import com.revature.voteappboot.data.UserRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import deployed.exceptions.UserDoesNotExistException;
import deployed.services.userService;
import dev.chopra.IncorrectCredentialsException;
import dev.chopra.UsernameAlreadyExistsException;


@SpringBootTest(classes=VoteAppBootApplication.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepo;
	
	@Autowired
	userService userServ;
	
	@Test
	public void CreateAcctsuccessfully() throws UserAlreadyExistsException {
		User u = new User();
		User mockUser = new User();
		// userRepo instead of UserDAO
		when(userRepo.save(u)).thenReturn(mockUser);
		
		User result = userServ.createAcct(u);
		
		// returns Username
		assertNotNull(result.getUsername());
	}
	@Test
	public void registerUsernameTaken() {
		User u = new User();
		u.setUsername("kchopr");
		
		// mock userDao.create(newUser)
		when(userRepo.save(u)).thenReturn(u);
		
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
		
		when(userRepo.findByUsername(username)).thenReturn(mockUser);
		
		User actualUser = userServ.logIn(username, password);
		
		assertEquals(mockUser, actualUser.getUsername());
		

}
	@Test
	public void logInWrongUsername() {
		String username = "ohno";
		String password = "thiswasright";
		
		// we need to mock userDao.getByUsername(username)
		when(userRepo.findByUsername(username)).thenReturn(null);
		
		assertThrows(IncorrectCredsException.class, () -> {
			userServ.logIn(username, password);
		});
	}

	@Test
	public void createPostSuccessfully() {
		
	}
}


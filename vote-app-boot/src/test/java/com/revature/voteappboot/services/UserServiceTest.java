package com.revature.voteappboot.services;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;




@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	@MockBean
	
	private CommentRepository commentRepository;
	@MockBean
	private PostRepository postRepository;
	@Autowired
	private userService userServ;
	
	
	
	public void CreateAcctsuccessfully() throws UserAlreadyExistsException {
		User u = new User();
		
		// mock userDao.create(u)
		when(userRepository.save(u)).thenReturn("TestUser");
		
		Boolean result = userServ.createAcct(u);
		
		// returns Username
		assertNotEquals(0, result.getUsername());
	}
	@Test
	public void registerUsernameTaken() {
		User u = new User();
		u.setUsername("kchopr");
		
		// mock userDao.create(newUser)
		when(userRepository.save(u)).thenReturn(1);
		
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
		
		when(userRepository.findByUsername(username)).thenReturn(mockUser);
		
		User actualUser = userServ.logIn(username, password);
		
		assertEquals(mockUser, actualUser);
		

}
	@Test
	public void logInWrongUsername() {
		String username = "abc123";
		String password = "1234567890";
		
		// we need to mock userDao.getByUsername(username)
		when(userRepository.findByUsername(username)).thenReturn(null);
		
		assertThrows(IncorrectCredsException.class, () -> {
			// put the code that we're expecting to throw the exception
			userServ.logIn(username, password);
		});
	}

}


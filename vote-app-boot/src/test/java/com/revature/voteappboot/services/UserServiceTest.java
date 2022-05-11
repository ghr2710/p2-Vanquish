package com.revature.voteappboot.services;

<<<<<<< HEAD
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.voteappboot.VoteAppBootApplication;
import com.revature.voteappboot.data.UserRepository;
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce

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

<<<<<<< HEAD

=======
import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import deployed.exceptions.UserDoesNotExistException;
import deployed.services.userService;
import dev.chopra.IncorrectCredentialsException;
import dev.chopra.UsernameAlreadyExistsException;
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce


@SpringBootTest(classes=VoteAppBootApplication.class)
public class UserServiceTest {
	
	@MockBean
<<<<<<< HEAD
	private UserRepository userRepository;
	@MockBean
	
	private CommentRepository commentRepository;
	@MockBean
	private PostRepository postRepository;
	@Autowired
	private userService userServ;
	
=======
	private UserRepository userRepo;
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce
	
	@Autowired
	userService userServ;
	
	@Test
	public void CreateAcctsuccessfully() throws UserAlreadyExistsException {
		User u = new User();
		User mockUser = new User();
		// userRepo instead of UserDAO
		when(userRepo.save(u)).thenReturn(mockUser);
		
<<<<<<< HEAD
		// mock userDao.create(u)
		when(userRepository.save(u)).thenReturn("TestUser");
		
		Boolean result = userServ.createAcct(u);
=======
		User result = userServ.createAcct(u);
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce
		
		// returns Username
		assertNotNull(result.getUsername());
	}
	@Test
	public void registerUsernameTaken() {
		User u = new User();
		u.setUsername("kchopr");
		
		// mock userDao.create(newUser)
<<<<<<< HEAD
		when(userRepository.save(u)).thenReturn(1);
=======
		when(userRepo.save(u)).thenReturn(u);
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce
		
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
		
<<<<<<< HEAD
		when(userRepository.findByUsername(username)).thenReturn(mockUser);
=======
		when(userRepo.findByUsername(username)).thenReturn(mockUser);
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce
		
		User actualUser = userServ.logIn(username, password);
		
		assertEquals(mockUser, actualUser.getUsername());
		

}
	@Test
	public void logInWrongUsername() {
		String username = "ohno";
		String password = "thiswasright";
		
		// we need to mock userDao.getByUsername(username)
<<<<<<< HEAD
		when(userRepository.findByUsername(username)).thenReturn(null);
=======
		when(userRepo.findByUsername(username)).thenReturn(null);
>>>>>>> bf1795a82c55ffef87ea1b4c835239cf9e9890ce
		
		assertThrows(IncorrectCredsException.class, () -> {
			userServ.logIn(username, password);
		});
	}

	@Test
	public void createPostSuccessfully() {
		
	}
}


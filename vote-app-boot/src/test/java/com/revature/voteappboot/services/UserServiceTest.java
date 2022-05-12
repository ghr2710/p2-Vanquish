package com.revature.voteappboot.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.voteappboot.VoteAppBootApplication;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.classes.Vote;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.data.VoteRepository;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import com.revature.voteappboot.exceptions.VoteAlreadyExistsException;



@SpringBootTest(classes=VoteAppBootApplication.class)
public class UserServiceTest {

	@MockBean
	private UserRepository userRepo;
	@MockBean
	private PostRepository postRepo;
	@MockBean
	private VoteRepository voteRepo;

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
		u.setUsername("kman");

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
		mockUser.setUsername("TestUser");
		mockUser.setPassword("TestPass");

		when(userRepo.findByUsername(username)).thenReturn(mockUser);

		User result = userServ.logIn(username, password);

		assertEquals(mockUser, result);


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
	public void loginIncorrectCredential() {
		User mockUser = new User();
		String username = "kman";
		String password = "kman123";

		mockUser.setUsername("wrong");
		mockUser.setPassword("alsoWrong");
		when(userRepo.findByUsername(username)).thenReturn(mockUser);

		assertThrows(IncorrectCredsException.class, () ->{
			userServ.logIn(username, password);
		});
	}
	@Test
	public void createPostSuccessfully() {
		Post p = new Post();
		Post mockPost = new Post();
		mockPost.setPostId(1);

		when(postRepo.save(p)).thenReturn(mockPost);

		Post result = userServ.createPost(p);

		assertNotEquals(0, result.getPostId());
	}

	@Test
	public void viewPostsSuccessfully() {
		when(postRepo.findAll()).thenReturn(Collections.emptyList());

		List<Post> posts = userServ.getAllPosts();

		assertNotNull(posts);
	}

	@Test
	public void addVoteSuccessfully() throws VoteAlreadyExistsException {
		Vote v = new Vote();
		Vote mockVote = new Vote();
		mockVote.setVoteId(1);
		when(voteRepo.save(v)).thenReturn(mockVote);

		assertNotNull(mockVote.getVoteId());

	}
}


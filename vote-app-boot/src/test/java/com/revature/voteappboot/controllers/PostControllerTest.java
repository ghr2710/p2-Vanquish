package com.revature.voteappboot.controllers;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.voteappboot.VoteAppBootApplication;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.services.userService;

@SpringBootTest(classes = VoteAppBootApplication.class)
public class PostControllerTest {
	@MockBean
	private userService userServ;
	@MockBean
	private PostRepository postRepo;
	@Autowired
	private PostController postController;
	@Autowired
	private WebApplicationContext context;

	private ObjectMapper jsonMapper = new ObjectMapper();

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void createPostSuccessfully()  {
		Post newPost = new Post();

		// mock userDao.create(newUser)
		Post mockPost = new Post();
		mockPost.setPostId(1);
		when(postRepo.save(newPost)).thenReturn(mockPost);

		Post result = userServ.createPost(newPost);

		// the behavior that i'm looking for is that the
		// method returns the User with their newly generated ID,
		// so i want to make sure the ID was generated (not the default)
		assertNotEquals(0, result.getPostId());
	}

	@Test
	public void getPostSuccesfully() throws JsonProcessingException, Exception {
		List<Post> mockPostList = Collections.emptyList();
		when(userServ.getAllPosts()).thenReturn(mockPostList);

		mockMvc.perform(get("/pets"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonMapper.writeValueAsString(mockPostList)));
	}




}
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
import com.revature.voteappboot.classes.Comment;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.services.userService;

@SpringBootTest(classes = VoteAppBootApplication.class)
public class CommentControllerTest {
	@Autowired
	private userService userServ;
	@MockBean
	private CommentRepository commentRepo;
	@Autowired
	private CommentController commentController;
	@Autowired
	private WebApplicationContext context;

	private ObjectMapper jsonMapper = new ObjectMapper();

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void createCommentSuccessfully()  {
		Comment newComment = new Comment();

		Comment mockComment = new Comment();
		mockComment.setCommentId(1);
		when(commentRepo.save(newComment)).thenReturn(mockComment);

		Comment result = userServ.createComment(newComment);

		assertNotEquals(0, result.getCommentId());
	}

	@Test
	public void getCommentsSuccesfully() throws JsonProcessingException, Exception {
		List<Comment> mockCommentsList = Collections.emptyList();
		when(userServ.getComments(1)).thenReturn(mockCommentsList);

		mockMvc.perform(get("/comment"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonMapper.writeValueAsString(mockCommentsList)));
	}


}
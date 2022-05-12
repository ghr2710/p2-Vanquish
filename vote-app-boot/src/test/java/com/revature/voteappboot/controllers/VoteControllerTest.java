package com.revature.voteappboot.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.revature.voteappboot.classes.Vote;
import com.revature.voteappboot.data.VoteRepository;
import com.revature.voteappboot.services.userService;

@SpringBootTest(classes = VoteAppBootApplication.class)
public class VoteControllerTest {
	@Autowired
	private userService userServ;

	@MockBean
	private VoteRepository voteRepo;

	@Autowired
	private WebApplicationContext context;


	private MockMvc mockMvc;

	private ObjectMapper jsonMapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addVoteSuccessfully() throws JsonProcessingException, Exception {
		Vote v = new Vote();
		Vote mockVote = new Vote();

		mockVote.setVoteId(1);
		when(voteRepo.save(v)).thenReturn(mockVote);

		mockMvc.perform(get("/votes"))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonMapper.writeValueAsString(mockVote)));

	}

}

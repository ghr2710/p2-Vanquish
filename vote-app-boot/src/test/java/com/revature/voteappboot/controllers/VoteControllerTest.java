package com.revature.voteappboot.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.voteappboot.VoteAppBootApplication;
import com.revature.voteappboot.data.VoteRepository;
import com.revature.voteappboot.services.userService;

@SpringBootTest(classes = VoteAppBootApplication.class)
public class VoteControllerTest {
	@MockBean
	private userService userServ;
	@MockBean
	private VoteRepository voteRepo;
	@Autowired
	private VoteController voteController;
	@Autowired
	private WebApplicationContext context;

	private ObjectMapper jsonMapper = new ObjectMapper();

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addVoteSuccessfully() {

	}

}

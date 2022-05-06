package com.revature.voteappboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.classes.Vote;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import com.revature.voteappboot.services.userService;

@RestController
@RequestMapping(path = "/vote")
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {
	private userService userServ;

	@Autowired
	public VoteController(userService userServ) {
		this.userServ = userServ;

	}

	@PostMapping
	public ResponseEntity<Vote> addVote(@RequestBody Vote v) {
		try {
			v = userServ.addVote(v);
			return ResponseEntity.ok(v);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}

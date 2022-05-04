package com.revature.voteappboot.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.services.userService;

@RestController
@RequestMapping(path="/auth")
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {
	private userService userServ;
	
	public AuthController(userService userServ) {
		this.userServ=userServ;
	}
	
	@PostMapping
	public ResponseEntity<User> logIn(@RequestBody Map<String,String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
		
		try {
			User u = userServ.logIn(username, password);
			return ResponseEntity.ok(u);
		} catch (IncorrectCredsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
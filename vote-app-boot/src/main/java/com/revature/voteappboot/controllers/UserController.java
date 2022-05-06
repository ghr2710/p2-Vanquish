package com.revature.voteappboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import com.revature.voteappboot.services.userService;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	private userService userServ;

	@Autowired
	public UserController(userService userServ) {
		this.userServ = userServ;

	}

	@PostMapping
	public ResponseEntity<User> createAcct(@RequestBody User u) {
		try {
			u = userServ.createAcct(u);
			return ResponseEntity.ok(u);
		} catch (UserAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}


	//	@GetMapping(path = "/{username}")
	//	public ResponseEntity<User> findByUsername(@PathVariable int username) {
	//		User user = userServ.findByUsername(username);
	//		if (user != null) {
	//			return ResponseEntity.ok(user);
	//		} else {
	//			return ResponseEntity.notFound().build();
	//		}
	//	}

	@PostMapping
	public void deleteUser(@RequestParam String username) {
		userService.deleteUser(username);
	}
}

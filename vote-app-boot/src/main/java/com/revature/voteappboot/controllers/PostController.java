package com.revature.voteappboot.controllers;

import java.util.List;
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

import com.revature.voteappboot.classes.Comment;
import com.revature.voteappboot.classes.Post;

import com.revature.voteappboot.services.userService;

@RestController
@RequestMapping(path="/post")
@CrossOrigin(origins="http://localhost:4200")

public class PostController {
	private userService userServ;

	@Autowired
	public PostController(userService userServ) {
		this.userServ = userServ;
	}

	@PostMapping 
	//create post 
	public ResponseEntity<Post> createPost(@RequestBody Post p) {
		p = userServ.createPost(p);	
	
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	//get all posts 
	@GetMapping
	public ResponseEntity<List<Post>> getPosts() {
		List<Post> p = userServ.getAllPosts();
		return ResponseEntity.ok(p);
	}


	//get posts by post ID
	@GetMapping(path="/{id}")
	public ResponseEntity<Post> getPosts(@PathVariable int id) {
		Post p = userServ.getPost(id);
		return ResponseEntity.ok(p);
	}
	
}

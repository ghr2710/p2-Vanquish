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
public ResponseEntity<Post> createPost(@RequestBody String postBody, String option1, String option2) {
	Post p = userServ.createPost(postBody, option1, option2);	
	
	if (p != null) {
		return ResponseEntity.ok(p);
	} else {
		return ResponseEntity.notFound().build();
	}
}

//get all posts 
@GetMapping
public ResponseEntity<List<Post>> getPost() {
	List<Post> p = userServ.getAllPosts();
	return ResponseEntity.ok(p);
}


//get posts by user id
@GetMapping(path="/{userid}")
public ResponseEntity<Post> getPosts(int id) {
	Post p = userServ.getPost(id);
	return ResponseEntity.ok(p);
}
	

	
	
	
	
}

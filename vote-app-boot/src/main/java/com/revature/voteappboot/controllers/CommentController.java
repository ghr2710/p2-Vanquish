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
import com.revature.voteappboot.services.userService;

@RestController
@RequestMapping(path="/comment")
@CrossOrigin(origins="http://localhost:4200")
public class CommentController {
private userService userServ;
	
	@Autowired
	public CommentController(userService userServ) {
		this.userServ = userServ;
}
	
	@PostMapping
	public ResponseEntity<Comment> createComment(@RequestBody Comment c){
		 c = userServ.createComment(c);
		 
		if (c != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping(path="/{CommentId}")
	public ResponseEntity<Comment> getcomment(@PathVariable int commentId) {
		Comment c = userServ.getComment(commentId);
		if (c != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping(path="/{postId}")
	public ResponseEntity<List<Comment>> getComments(int postId) {
		List<Comment> c = userServ.getComments(postId);
		return ResponseEntity.ok(c);
	}
}
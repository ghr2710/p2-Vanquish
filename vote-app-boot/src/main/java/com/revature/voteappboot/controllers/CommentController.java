package com.revature.voteappboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<Comment> createComment(@RequestBody String username, String Body, int rel ){
		 Comment c = userServ.createComment(username, Body, rel);
		 
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
	@GetMapping(path="/{commentsid}")
	public ResponseEntity<List<Comment>> getComments(int id) {
		List<Comment> c = userServ.getComments(id);
		return ResponseEntity.ok(c);
	}
}
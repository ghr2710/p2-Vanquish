package com.revature.voteappboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.voteappboot.classes.Comment;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;

@Service
public class userService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	private CommentRepository commentRepo;

	@Autowired
	public userService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.commentRepo = commentRepo;
	}

	public User createAcct(User u) throws UserAlreadyExistsException{
		String uName = userRepo.save(u).getUsername();

		if(uName != "") {
			return u;
		}
		else {
			throw new UserAlreadyExistsException();
		}
	}

	public User logIn(String username, String password) throws IncorrectCredsException{
		User u = new User();
		u = userRepo.findByUsername(username);
		if (u != null && u.getPassword().equals(password)) {
			return u;
		} else {
			throw new IncorrectCredsException();
		}

	}

	public Post createPost(String postBody, String option1, String option2) {
		Post p = new Post();
		p.setPostBody(postBody);
		p.setOption1(option1);
		p.setOption2(option2);

		int id = postRepo.save(p).getPostId();

		if(id != 0) {
			p.setPostId(id);
		}

		return p;

	}

	public Post getPost(int id) {
		Post p = postRepo.getById(id);
		return p;
	}

	public List<Post> getAllPosts(){
		List<Post> postList = postRepo.findAll();
		return postList;
	}

	public Comment createComment(Comment c) {
		int id = commentRepo.save(c).getCommentId();

		if(id != 0) {
			c.setCommentId(id);
		}

		return c;

	}

	public Comment getComment(int id) {
		return commentRepo.getById(id);
	}

	public List<Comment> getComments(int postId) {
		return commentRepo.findById(postId);

	}

	public static void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	public User findByUsername(int username) {
		// TODO Auto-generated method stub
		return null;
	}


}
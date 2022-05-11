package com.revature.voteappboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.voteappboot.classes.Comment;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.classes.Vote;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.data.VoteRepository;
import com.revature.voteappboot.exceptions.IncorrectCredsException;
import com.revature.voteappboot.exceptions.UserAlreadyExistsException;
import com.revature.voteappboot.exceptions.VoteAlreadyExistsException;

@Service
public class userService {

	private UserRepository userRepo;
	private PostRepository postRepo;
	private VoteRepository voteRepo;
	private CommentRepository commentRepo;

	@Autowired
	public userService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, VoteRepository voteRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.voteRepo = voteRepo;
		this.commentRepo = commentRepo;
	}

	public User createAcct(User u) throws UserAlreadyExistsException{
		User search = userRepo.findByUsername(u.getUsername());

		if(search == null) {
			String uName = userRepo.save(u).getUsername();
			return u;
		}
		else {
			throw new UserAlreadyExistsException();
		}
	}

	public User logIn(String username, String password) throws IncorrectCredsException{
		User u = userRepo.findByUsername(username);
		if (u != null && u.getPassword().equals(password)) {
			return u;
		} else {
			throw new IncorrectCredsException();
		}

	}
	
	public Post createPost(Post p) {
		int id = postRepo.save(p).getPostId();

		if(id != 0) {
			p.setPostId(id);
		}

		return p;

	}

	public Post getPost(int id) {
		Post p = postRepo.findById(id);
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
		return commentRepo.findById(id);
	}

	public List<Comment> getComments(int postId) {
		return commentRepo.findByPostid(postId);
	}
	
	public Vote addVote(Vote v) throws VoteAlreadyExistsException {
		Vote search = voteRepo.findByUsernameAndPostid(v.getUsername(), v.getPostId());
		
		if(search == null) {
			String uName = voteRepo.save(v).getUsername();
			return v;
		}
		else {
			throw new VoteAlreadyExistsException();
		}

	}

}
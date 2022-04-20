package deployed.services;

import java.util.Date;

import deployed.classes.*;
import deployed.exceptions.*;

public class userService {
	
	//ADD DAO STUFF HERE
	
	public userService() {
		//DECLARE DAO's HERE
	}
	
	public Boolean createAcct(User u) throws UserAlreadyExistsException{
		Boolean exists = false;
		try {
			//exists = DAO.userExists(u.getUsername());
		}
		catch (Exception e) {
			//User exists query went wrong
			return false;
		}
		
		Boolean userCreated = false;
		
		if (!exists) {
			try {
				//userCreated = DAO.createUser(u);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			//That username already exists
			throw new UserAlreadyExistsException();
		}
		if (userCreated) {
			//User created successfully
			return true;
		}
		else {
			//User creation failed due to SQL error
			return false;
		}
	}
	
	public void  deleteUser(String username) throws UserDoesNotExistException{
		// Boolean exists = DAO.userExists(username)
		// Post[] postList = getUserPosts();
		//Comment[] commentList = getUserComments();
		//for(int i=0; i<postList.length; i++){
			//deletePost(postList[i].getPostId());
		//}
		//for(int i=0; i<commentList.length; i++){
			//deleteComment(commentList[i].getCommentId());
		//}
		// DAO.deleteUser(username);	
	}
	
	public User logIn(String username, String password) throws IncorrectCredsException{
		User u = new User();
		//Boolean exists = DAO.userExists(username);
		Boolean exists = true; //placeholder code to be removed later
		if (exists) {
			try {
				//u = DAO.getUser(uName);
			}
			catch (Exception e) {
				System.out.println("Request user query went wrong");
			}
			if (u != null) {
				if (password.equals(u.getPassword())) {
					System.out.println("Login Successful");
				}
				else {
					throw new IncorrectCredsException();
				}
			}
			else {
				return null;
			}
		}
		else {
			throw new IncorrectCredsException();
		}
		return u;
	}
	
	public Post createPost(String postBody, String option1, String option2) {
		Post p = new Post();
		// PostDAO.createPost();

		return p;

	}

	public void deletePost(int postId) {
		//Comment[] commentList = DAO.getComments(postId);
		//for(int i=0; i<commentList.length; i++) {
		//	deleteComment(commentList[i].getCommentId());
		//}
		//DAO.deletePost(postId);
	}

	public boolean editPost(Post p) {
		Date today = new Date();
		p.setDatePosted(today);
		//Boolean result = postDAO.update(p);
		return result;
	}

	public Post getPost(int id) {
		Post p = PostDAO.getById(id);
		return p;
	}

	public Post[] getUserPosts(User u) {
		Post[] postList = postDAO.getPostsByUser();

		return postList;

	}

	public Post[] getAllPosts(){
		Post[] postList = postDAO.getAllPosts();
		return postList;
	}
	
	public void createComment(String username, String Body, int rel) {
		Comment c = new Comment();
		c.setCommentBody(Body);
		c.setUsername(username);
		c.setRelatedPost(rel);
		//c.setCommentId (0);
		
		//commentDAO.create(c);
	
	} 
	
	public void deleteComment(int id) {
	//	commentDAO.deleteComment(id);
	}
		
	
	public Boolean editCommnet(Comment c) {
		Date today = new Date();
		c.setDatePosted(today);
		 
		// Boolean result = commentDAO.update(c);

		return true;
	}
	
	public Comment getComment(int id) {
		return commentDAO.getById(id);
	}
	
	public Comment[] getUserComments(User u) {
		return commentDAO.getByUser(u.getUsername());
	}
	
	public Comment[] getComments(int id) {
		return commentDAO.getByPost(id);
		
	}
}

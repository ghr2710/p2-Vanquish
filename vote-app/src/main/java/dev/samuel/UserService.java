package dev.samuel;



import java.util.Date;
import java.util.List;

import com.revature.models.Pitch;

import dev.khayman.*;


public class UserService {
	
	
	public void  createComment(String username, String Body, int rel) {
		Comments c = new Comments();
		c.setCommentBody(Body);
		c.setUsername(username);
		c.setRelatedPost(rel);
		//c.setCommentId (0);
		
		//commentDao.create(c);
	
	} 
	
	public void  deleteComment(int id) {
	//	commentDAO.deleteComment(id);
	}
		
	
	public Boolean editCommnet(Comments c) {
		
		Date today = new Date();
		c.setDatePosted(today);
		 
		// Boolean result = commentDAO.update(c);

		return true;
	}
	
	public  Comments getComment(int id) {
		
		return commentDAO.getById(id);
	}
	
	public Comments getUserComments(User u) {
		return commentDAO.getById(u);
		
	}
	
	
	public Comments getComments(int id) {
		return commentDAO.getById(id);
		
	}
	
	
}



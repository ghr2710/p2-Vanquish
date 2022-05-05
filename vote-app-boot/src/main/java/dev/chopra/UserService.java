package dev.chopra;



import org.springframework.stereotype.Service;

import com.revature.voteappboot.data.PostRepository;
import com.revature.voteappboot.data.CommentRepository;
import com.revature.voteappboot.data.UserRepository;
import com.revature.voteappboot.services.userService;

import dev.khayman.User;


@Service
public class UserService {
	
	
		// field injection
		//@Autowired
		private UserRepository userRepo;
		//@Autowired
		private PostRepository postRepo;
		private CommentRepository commentRepo;
	public User register(String Username, String password) {
		User u = new User(Username, password);
		// DAO.createUser(u);
		return u;
	}
	public void  deleteUser(String username) {
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
	public User logIn(String username, String password) {
		//User user = UserDao.getByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
	}

}
}
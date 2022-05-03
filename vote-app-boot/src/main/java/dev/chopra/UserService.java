package dev.chopra;



import dev.khayman.User;

public class UserService {
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
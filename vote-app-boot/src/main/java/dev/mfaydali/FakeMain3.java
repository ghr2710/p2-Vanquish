package dev.mfaydali;

public class FakeMain3 {
	// Post[] postList = getUserPosts();
	// Comment[] commentList = getUserComments();
	//for(int i=0; i<postList.length; i++){
	// deletePost(postList[i].getPostId());

	//}
	//for(int i=0; i<commentList.length; i++){
	// deleteComment(commentList[i].getCommentId());
	//}
	//DAO.deleteUser(username);



	//	public Votes[] checkVotes(String username) {
	//		Votes [] v = VotesDAO.getByUsername(username);
	//		return v;
	//	}



	//	package com.revature.voteappboot.data;
	//
	//	import org.springframework.data.jpa.repository.JpaRepository;
	//	import org.springframework.stereotype.Repository;
	//
	//	import com.revature.voteappboot.classes.User;
	//
	//	@Repository
	//	public interface UserRepository extends JpaRepository<User, Integer> {
	//		public User findByUsername(String username);
	//		public User createUser(String username, String password);
	//		public User logIn(String username, String password);
	//		public User deleteUser(String username);
	//	}


	//	Spring JPA - User Repository
	//
	//	create user
	//	log-in
	//	delete user (also deletes all posts attached to the user)

	//	@PostMapping
	//	public User logIn(@RequestBody String username, String password) {
	//		return userService.logIn();
	//	}

	//	 @PostMapping
	//	    public User createUser(@RequestBody User user) {
	//	        return userService.createAcct(user);
	//	    }

	//	 @PostMapping
	//    public void deleteUser(@RequestParam String username) {
	//        userService.delete(username);
	//    }




	//	  @RequestMapping(value="/create")
	//	  @ResponseBody
	//	  public String create(String username, String password) {
	//	    try {
	//	      User user = new User(username, password);
	//	      userDao.create(user);
	//	    }
	//	    catch (Exception ex) {
	//	      return "Error creating the user: " + ex.toString();
	//	    }
	//	    return "User succesfully created!";
	//	  }
}

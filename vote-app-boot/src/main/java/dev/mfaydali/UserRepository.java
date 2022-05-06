package com.revature.voteappboot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.voteappboot.classes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	public User createUser(User user);
	public User logIn(String username, String password);
	public User deleteUser(String username);
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
}

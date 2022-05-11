package com.revature.voteappboot.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.voteappboot.classes.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	public User findByUsername(String username);
}

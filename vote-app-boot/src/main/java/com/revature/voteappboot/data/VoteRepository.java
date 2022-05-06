package com.revature.voteappboot.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.voteappboot.classes.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
	public Vote findByUsername(String username);

}

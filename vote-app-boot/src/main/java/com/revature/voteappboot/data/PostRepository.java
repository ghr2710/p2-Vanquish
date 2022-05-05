package com.revature.voteappboot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.classes.Comment;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	public Post[] getAllPosts();
}

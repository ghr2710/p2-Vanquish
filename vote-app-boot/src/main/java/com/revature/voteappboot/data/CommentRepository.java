package com.revature.voteappboot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.voteappboot.classes.User;
import com.revature.voteappboot.classes.Post;
import com.revature.voteappboot.classes.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	public List<Comment> findByPostid(int postID);
	public Comment findById(int id);
}

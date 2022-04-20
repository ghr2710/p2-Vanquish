package dev.mfaydali;

import java.util.Date;
import java.util.List;

import dev.khayman.Post;
import dev.khayman.User;

public class UserService {

	public Post createPost(String postBody, String option1, String option2) {
		Post p = new Post();
		// PostDAO.createPost();

		return p;

	}

	public void deletePost(int postId) {

		//Comment[] commentList = getUserComments();

		//deleteComment(commentList[i].getCommentId());

		//	for(int i=0; i<postList.length; i++){ deletePost(postList[i].getPostId()); }
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


}


package com.assignment.project.service.impl;

import com.assignment.project.exception.ResourceNotFoundException;
import com.assignment.project.model.Post;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.PostRequest;
import com.assignment.project.payload.PostResponse;
import com.assignment.project.repository.PostRepository;
import com.assignment.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.assignment.project.utils.AppConstants.ID;
import static com.assignment.project.utils.AppConstants.POST;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> getAllPosts() {

		List<Post> posts = postRepository.findAll();
		return posts;

	}


	@Override
	public Post updatePost(Long id, PostRequest newPostRequest) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
		post.setTitle(newPostRequest.getTitle());
		post.setBody(newPostRequest.getBody());
		return postRepository.save(post);
	}

	@Override
	public ApiResponse deletePost(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
		postRepository.deleteById(id);
		return new ApiResponse(Boolean.TRUE, "You successfully deleted post");
	}

	@Override
	public PostResponse addPost(PostRequest postRequest) {

		Post post = new Post();
		post.setBody(postRequest.getBody());
		post.setTitle(postRequest.getTitle());
		post.setLikes(0L);
		post.setDislikes(0L);
		Post newPost = postRepository.save(post);

		PostResponse postResponse = new PostResponse();

		postResponse.setTitle(newPost.getTitle());
		postResponse.setBody(newPost.getBody());
		postResponse.setLikes(0l);
		postResponse.setDislikes(0l);

		return postResponse;
	}

	@Override
	public Post getPost(Long id) {
		return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
	}

	@Override
	public Post like(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
		post.incLikes();
		postRepository.save(post);
		System.out.println(post.getLikes());

		return post;
	}

	@Override
	public Post dislike(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
		post.incDislikes();
		postRepository.save(post);

		return post;
	}

	@Override
	public Post mostLiked(String title) {
		Post post = postRepository.findByTitle(title).get(0);
		return post;
	}

}

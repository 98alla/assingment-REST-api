package com.assignment.project.service;

import com.assignment.project.model.Post;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.PostRequest;
import com.assignment.project.payload.PostResponse;

import java.util.List;

public interface PostService {

	List<Post> getAllPosts();

	Post updatePost(Long id, PostRequest newPostRequest);

	ApiResponse deletePost(Long id);

	PostResponse addPost(PostRequest postRequest);

	Post getPost(Long id);

    Post like(Long id);

	Post dislike(Long id);

    Post mostLiked(String title);
}

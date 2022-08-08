package com.assignment.project.controller;

import com.assignment.project.model.Post;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.PostRequest;
import com.assignment.project.payload.PostResponse;
import com.assignment.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> response = postService.getAllPosts();

		return new ResponseEntity< >(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PostResponse> addPost(@RequestBody PostRequest postRequest) {
		System.out.println(postRequest.getTitle() + " " + postRequest.getBody());
		PostResponse postResponse = postService.addPost(postRequest);

		return new ResponseEntity< >(postResponse, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPost(@PathVariable(name = "id") Long id) {
		Post post = postService.getPost(id);

		return new ResponseEntity< >(post, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable(name = "id") Long id,
			@Valid @RequestBody PostRequest newPostRequest) {
		Post post = postService.updatePost(id, newPostRequest);

		return new ResponseEntity< >(post, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
		ApiResponse apiResponse = postService.deletePost(id);

		return new ResponseEntity< >(apiResponse, HttpStatus.OK);
	}
	@PostMapping("/{id}/like")
	public ResponseEntity<Post> likePost(@PathVariable(name = "id") Long id){
		Post post = postService.like(id);
		return new ResponseEntity< >(post, HttpStatus.OK);
	}

	@PostMapping("/{id}/dislike")
	public ResponseEntity<Post> dislikePost(@PathVariable(name = "id") Long id){
		Post post = postService.dislike(id);
		return new ResponseEntity< >(post, HttpStatus.OK);
	}
}

package com.assignment.project.controller;

import com.assignment.project.model.Comment;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.CommentRequest;
import com.assignment.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@GetMapping
	public ResponseEntity<List<Comment>> getAllComments(@PathVariable(name = "postId") Long postId) {

		List<Comment> allComments = commentService.getAllComments(postId);

		return new ResponseEntity< >(allComments, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentRequest commentRequest,
			@PathVariable(name = "postId") Long postId) {
		Comment newComment = commentService.addComment(commentRequest, postId);

		return new ResponseEntity<>(newComment, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comment> getComment(@PathVariable(name = "postId") Long postId,
			@PathVariable(name = "id") Long id) {
		Comment comment = commentService.getComment(postId, id);

		return new ResponseEntity<>(comment, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable(name = "postId") Long postId,
			@PathVariable(name = "id") Long id, @Valid @RequestBody CommentRequest commentRequest) {

		Comment updatedComment = commentService.updateComment(postId, id, commentRequest);

		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable(name = "postId") Long postId,
			@PathVariable(name = "id") Long id) {

		ApiResponse response = commentService.deleteComment(postId, id);

		HttpStatus status = response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

		return new ResponseEntity<>(response, status);
	}

}

package com.assignment.project.service.impl;

import com.assignment.project.exception.BlogapiException;
import com.assignment.project.exception.ResourceNotFoundException;
import com.assignment.project.model.Comment;
import com.assignment.project.model.Post;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.CommentRequest;
import com.assignment.project.repository.CommentRepository;
import com.assignment.project.repository.PostRepository;
import com.assignment.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

	private static final String ID_STR = "id";

	private static final String COMMENT_STR = "Comment";

	private static final String POST_STR = "Post";

	private static final String COMMENT_DOES_NOT_BELONG_TO_POST = "Comment does not belong to post";

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Comment> getAllComments(Long postId) {
		List<Comment> comments = commentRepository.findByPostId(postId);
		return comments;
	}

	@Override
	public Comment addComment(CommentRequest commentRequest, Long postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = new Comment(commentRequest.getBody());
		comment.setPost(post);
		return commentRepository.save(comment);
	}

	@Override
	public Comment getComment(Long postId, Long id) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));
		if (comment.getPost().getId().equals(post.getId())) {
			return comment;
		}

		throw new BlogapiException(HttpStatus.BAD_REQUEST, COMMENT_DOES_NOT_BELONG_TO_POST);
	}

	@Override
	public Comment updateComment(Long postId, Long id, CommentRequest commentRequest) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogapiException(HttpStatus.BAD_REQUEST, COMMENT_DOES_NOT_BELONG_TO_POST);
		}
			comment.setBody(commentRequest.getBody());
			return commentRepository.save(comment);

	}

	@Override
	public ApiResponse deleteComment(Long postId, Long id) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

		if (!comment.getPost().getId().equals(post.getId())) {
			return new ApiResponse(Boolean.FALSE, COMMENT_DOES_NOT_BELONG_TO_POST);
		}

			commentRepository.deleteById(comment.getId());
			return new ApiResponse(Boolean.TRUE, "You successfully deleted comment");

	}
}

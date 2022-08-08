package com.assignment.project.service;

import com.assignment.project.model.Comment;
import com.assignment.project.payload.ApiResponse;
import com.assignment.project.payload.CommentRequest;

import java.util.List;


public interface CommentService {

	List<Comment> getAllComments(Long postId);

	Comment addComment(CommentRequest commentRequest, Long postId);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest);

	ApiResponse deleteComment(Long postId, Long id);

}

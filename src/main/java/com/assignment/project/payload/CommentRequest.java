package com.assignment.project.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CommentRequest {
	@NotBlank
	@Size(min = 1, message = "Comment cannot be empty!")
	private String body;
}

package com.assignment.project.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class PostRequest {

	@NotBlank
	@Size(min = 1)
	private String title;

	@NotBlank
	private String body;


	private Long likes;


	private Long dislikes;

}

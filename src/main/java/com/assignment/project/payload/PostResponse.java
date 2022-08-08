package com.assignment.project.payload;

import lombok.Data;

@Data
public class PostResponse {
	private String title;
	private String body;
	private Long likes;
	private Long dislikes;
}

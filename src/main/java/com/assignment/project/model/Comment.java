package com.assignment.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body")
    @NotBlank
    @Size(min = 1, message = "Comment cannot be blank!")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


    public Comment(@NotBlank @Size(min = 1, message = "Comment cannot be blank!") String body) {
        this.body = body;
    }

    @JsonIgnore
    public Post getPost() {
        return post;
    }

}

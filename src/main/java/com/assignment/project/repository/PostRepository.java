package com.assignment.project.repository;

import com.assignment.project.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query( value = "select * from posts p where p.title = ?1 order by likes desc",nativeQuery=true)
    List<Post> findByTitle(String title);

}

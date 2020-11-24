package com.studybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studybook.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}

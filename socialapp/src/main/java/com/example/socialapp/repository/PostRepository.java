package com.example.socialapp.repository;

import com.example.socialapp.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    List<Post> findByUserIdOrderByTimestampDesc(Long userId);
    Page<Post> findByUserId(Long userId, Pageable pageable);
}


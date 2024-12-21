package com.petproject.tech_blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petproject.tech_blog.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
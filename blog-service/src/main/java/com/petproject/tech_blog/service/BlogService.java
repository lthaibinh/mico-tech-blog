package com.petproject.tech_blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petproject.tech_blog.entity.Blog;
import com.petproject.tech_blog.repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);

        // return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blog) {
        Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
        existingBlog.setAuthor(blog.getAuthor());
        return blogRepository.save(existingBlog);
    }

    public void deleteBlog(Long id) {
        Blog blog = getBlogById(id);
        blogRepository.delete(blog);
    }
}

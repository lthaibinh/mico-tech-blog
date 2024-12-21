package com.petproject.tech_blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petproject.tech_blog.entity.Blog;
import com.petproject.tech_blog.payload.response.SuccessResponse;
import com.petproject.tech_blog.service.BlogService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<SuccessResponse<List<Blog>>> getAllBlogs() {
        return SuccessResponse.of(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Blog>> getBlogById(@PathVariable String id) {
        return SuccessResponse.of(blogService.getBlogById(Long.parseLong(id)));
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SuccessResponse<Blog>> createBlog(@RequestBody Blog blog) {
        return SuccessResponse.of(blogService.createBlog(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<Blog>> updateBlog(@PathVariable String id, @RequestBody Blog entity) {
        return SuccessResponse.of(blogService.updateBlog(Long.parseLong(id), entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Void>> deleteBlog(@PathVariable String id) {
        blogService.deleteBlog(Long.parseLong(id));
        return SuccessResponse.of(null);
    }

}

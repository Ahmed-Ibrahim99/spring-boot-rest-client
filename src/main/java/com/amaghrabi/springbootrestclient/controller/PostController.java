package com.amaghrabi.springbootrestclient.controller;

import com.amaghrabi.springbootrestclient.model.Post;
import com.amaghrabi.springbootrestclient.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    public final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAll")
    public List<Post> getAll() {
        return this.postService.getAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id){
        return this.postService.findById(id);
    }

    @PostMapping()
    public Post create(@RequestBody Post post){
        return this.postService.create(post);
    }

    @PutMapping()
    public Post update(Long id, @RequestBody Post post){
        return this.postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.postService.delete(id);
    }
}

package com.amaghrabi.springbootrestclient.service;

import com.amaghrabi.springbootrestclient.model.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {

    public final RestClient restClient;

    @Value("${api.base.url}")
    private String apiBaseUrl;

    public PostService() {
        this.restClient = RestClient
                .builder()
                .baseUrl(apiBaseUrl)
                .build();
    }

    public List<Post> getAll() {
        return this.restClient
                .get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {
                });
    }

    public Post findById(Long id) {
        return this.restClient
                .get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

    public Post create(Post post) {
        return this.restClient
                .post()
                .uri("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);
    }

    public Post update(Long id, Post post) {
        return this.restClient
                .put()
                .uri("/posts/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(post)
                .retrieve()
                .body(Post.class);

    }

    public void delete(Long id) {
        this.restClient
                .delete()
                .uri("/posts/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}

package com.gulukal.blogspringtrestapi.controller;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.service.PostService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gulten Ulukal
 */

@RestController
@RequestMapping("/api/posts")
public class PostController {

    /**
     * Construction dependency injection
     */
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create blog post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);

    }
}

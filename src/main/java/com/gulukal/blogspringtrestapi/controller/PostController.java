package com.gulukal.blogspringtrestapi.controller;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.dto.PostResponse;
import com.gulukal.blogspringtrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //create post rest api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //get all post rest api
    //http://localhost:8080/api/posts?pageNo=5&pageSize=2  test it
    //http://localhost:8080/api/posts?pageNo=2&pageSize=4&sortBy=title test with sortby
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value= "sortBy",defaultValue = "id", required = false) String sortBy
    ) {
        return postService.getAllPosts(pageNo, pageSize,sortBy);
    }

    //get post by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    //update post by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {

        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //delete post by id rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {

        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}

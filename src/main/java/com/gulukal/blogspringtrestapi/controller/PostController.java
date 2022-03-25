package com.gulukal.blogspringtrestapi.controller;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.dto.PostDtoV2;
import com.gulukal.blogspringtrestapi.dto.PostResponse;
import com.gulukal.blogspringtrestapi.service.PostService;
import com.gulukal.blogspringtrestapi.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gulten Ulukal
 */

@RestController
@RequestMapping()
public class PostController {

    /**
     * Construction dependency injection
     */
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //only admin can access this method
    @PreAuthorize("hasRole('ADMIN')")
    //create post rest api
    //@Valid annotation must be added for validation
    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    //get all post rest api
    //http://localhost:8080/api/posts?pageNo=5&pageSize=2  test it diffrent from default
    //http://localhost:8080/api/posts?pageNo=2&pageSize=4&sortBy=title test with sortby diffrent from default
    //http://localhost:8080/api/posts?pageNo=2&pageSize=4&sortBy=title&sortDir=dsc
    //http://localhost:8080/api/posts?pageNo=2&pageSize=4&sortBy=title&sortDir=asc
    @GetMapping("/api/v1/posts")
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value= "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir

    ) {
        return postService.getAllPosts(pageNo, pageSize,sortBy,sortDir);
    }

    //get post by id rest api
    @GetMapping("/api/v2/posts/{id}")
    public ResponseEntity<PostDtoV2> getPostById(@PathVariable(name = "id") long id) {
        PostDto postDto = postService.getPostById(id);
        PostDtoV2 postDtoV2 = new PostDtoV2();
        postDtoV2.setId(postDto.getId());
        postDtoV2.setTitle(postDto.getTitle());
        postDtoV2.setDescription(postDto.getDescription());
        postDtoV2.setContent(postDto.getContent());


        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("Spring Boot");
        tags.add("AWS");
        postDtoV2.setTags(tags);

        return ResponseEntity.ok(postDtoV2);
    }

    //only admin can access this method
    @PreAuthorize("hasRole('ADMIN')")
    //update post by id rest api
    @PutMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable(name = "id") long id) {

        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    //only admin can access this method
    @PreAuthorize("hasRole('ADMIN')")
    //delete post by id rest api
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {

        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }

}

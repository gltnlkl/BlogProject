package com.gulukal.blogspringtrestapi.service;

import com.gulukal.blogspringtrestapi.dto.PostDto;

import java.util.List;

/**
 * @author Gulten Ulukal
 */

public interface PostService {


    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById( long id);

}

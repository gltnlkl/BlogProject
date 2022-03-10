package com.gulukal.blogspringtrestapi.service.impl;

import com.gulukal.blogspringtrestapi.dto.PostDto;
import com.gulukal.blogspringtrestapi.entity.Post;
import com.gulukal.blogspringtrestapi.repository.PostRepository;
import com.gulukal.blogspringtrestapi.service.PostService;
import org.springframework.stereotype.Service;

/**
 * @author Gulten Ulukal
 */

@Service
public class PostServiceImpl implements PostService {

    /**
     * Construction dependency injection
     */
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert dto to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newPost = postRepository.save(post);

        //convert entity to dto
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());

        return postResponse;
    }
}

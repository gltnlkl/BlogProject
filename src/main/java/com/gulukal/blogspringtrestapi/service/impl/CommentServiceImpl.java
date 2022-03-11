package com.gulukal.blogspringtrestapi.service.impl;

import com.gulukal.blogspringtrestapi.dto.CommentDto;
import com.gulukal.blogspringtrestapi.entity.Comment;
import com.gulukal.blogspringtrestapi.entity.Post;
import com.gulukal.blogspringtrestapi.exception.BlogApiException;
import com.gulukal.blogspringtrestapi.exception.ResourceNotFoundException;
import com.gulukal.blogspringtrestapi.repository.CommentRepository;
import com.gulukal.blogspringtrestapi.repository.PostRepository;
import com.gulukal.blogspringtrestapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gulten Ulukal
 */

@Service
public class CommentServiceImpl implements CommentService {

    /**
     * Construction dependency injection
     */

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment =mapToEntity(commentDto);

        //retrieve post entity by id
        Post post = retrievePostEntityById(postId);

        //set post to comment entity
        comment.setPost(post);

        //save comment entity to db
        Comment newComment =  commentRepository.save(comment);

        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {

        //retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        //convert list of comment entities to list of comment
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {

        //retrieve post entity by id
        Post post = retrievePostEntityById(postId);

        //retrieve comment by id
        Comment comment = retrieveCommentById(commentId);

        //badRequestException IF ELSE
        badRequestException(comment, post);

        return mapToDto(comment);

    }

    @Override
    public CommentDto updateComment(long postId, long commentId, CommentDto commentRequest) {

        //retrieve post entity by id
        Post post = retrievePostEntityById(postId);

        //retrieve comment by id
        Comment comment = retrieveCommentById(commentId);

        //badRequestException IF ELSE
        badRequestException(comment, post);

        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);

        return mapToDto(updatedComment);

    }

    //badRequestException IF ELSE
    private void badRequestException(Comment comment, Post post) {

        if (((comment.getPost().getId()) != (post.getId()))) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

    }

    //retrieve post entity by id
    private Post retrievePostEntityById(long postId) {

        return postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));
    }

    //retrieve comment by id
    private Comment retrieveCommentById(long commentId) {

        return commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "commentId", commentId));
    }

    //convert entity to dto
    private CommentDto mapToDto(Comment comment) {

        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

    //convert dto to entity
    private Comment mapToEntity(CommentDto commentDto) {

        return Comment.builder()
                .id(commentDto.getId())
                .name(commentDto.getName())
                .email(commentDto.getEmail())
                .body(commentDto.getBody())
                .build();
    }
}

package com.gulukal.blogspringtrestapi.dto;

import lombok.*;

import java.util.Set;

/**
 * @author Gulten Ulukal
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class PostDto {

    private long id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> comments;

}

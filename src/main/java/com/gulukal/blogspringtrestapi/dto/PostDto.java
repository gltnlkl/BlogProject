package com.gulukal.blogspringtrestapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Gulten Ulukal
 */

@Data
@Builder
public class PostDto {

    private long id;
    private String title;
    private String description;
    private String content;

}

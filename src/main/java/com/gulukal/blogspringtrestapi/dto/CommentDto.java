package com.gulukal.blogspringtrestapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Gulten Ulukal
 */

@Data
@Builder

public class CommentDto {

    private long id;
    private String name;
    private String email;
    private String body;


}

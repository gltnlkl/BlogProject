package com.gulukal.blogspringtrestapi.dto;

import lombok.Data;

/**
 * @author Gulten Ulukal
 */

@Data

public class CommentDto {

    private long id;
    private String name;
    private String email;
    private String body;


}

package com.gulukal.blogspringtrestapi.dto;

import lombok.Data;

/**
 * @author Gulten Ulukal
 */

@Data
public class PostDto {

    private long id;
    private String title;
    private String discription;
    private String content;

}

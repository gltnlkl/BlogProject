package com.gulukal.blogspringtrestapi.dto;

import lombok.*;

/**
 * @author Gulten Ulukal
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CommentDto {

    private long id;
    private String name;
    private String email;
    private String body;


}

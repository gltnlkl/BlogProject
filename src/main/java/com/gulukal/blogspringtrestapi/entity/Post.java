package com.gulukal.blogspringtrestapi.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Gulten Ulukal
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;
}

package com.server.spring.feign.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    /**
     * The ID of the user who created the post.
     */
    private int userId;
    /**
     * The unique ID of the post.
     */
    private int id;
    /**
     * The title of the post.
     */
    private String title;
    /**
     * The body content of the post.
     */
    private String body;
}

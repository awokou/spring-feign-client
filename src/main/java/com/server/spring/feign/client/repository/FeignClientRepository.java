package com.server.spring.feign.client.repository;

import com.server.spring.feign.client.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Feign client interface for interacting with the JSONPlaceholder API.
 */
@FeignClient(value = "placeholder", url = "https://jsonplaceholder.typicode.com/")
public interface FeignClientRepository {

    /**
     * Retrieves a list of posts from the JSONPlaceholder API.
     *
     * @return a list of Post objects
     */
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();
}

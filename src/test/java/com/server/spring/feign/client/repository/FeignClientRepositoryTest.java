package com.server.spring.feign.client.repository;

import com.server.spring.feign.client.dto.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeignClientRepositoryTest {

    @Mock
    private FeignClientRepository feignClientRepository;

    @BeforeEach
    void setUp() {
        feignClientRepository = Mockito.mock(FeignClientRepository.class);
    }

    @Test
    void getPosts_returnsListOfPosts() {
        List<Post> expectedPosts = List.of(new Post());
        when(feignClientRepository.getPosts()).thenReturn(expectedPosts);

        List<Post> actualPosts = feignClientRepository.getPosts();

        assertEquals(expectedPosts, actualPosts);
    }

    @Test
    void getPosts_returnsEmptyListWhenNoPosts() {
        when(feignClientRepository.getPosts()).thenReturn(Collections.emptyList());

        List<Post> actualPosts = feignClientRepository.getPosts();

        assertEquals(Collections.emptyList(), actualPosts);
    }
}

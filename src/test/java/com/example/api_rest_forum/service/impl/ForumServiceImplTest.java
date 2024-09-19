package com.example.api_rest_forum.service.impl;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.repository.ForumRepository;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.impl.ForumServiceImpl;
import com.example.api_rest_forum.services.mappers.ForumMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ForumServiceImplTest {

    @Mock
    private ForumRepository forumRepository;

    @Mock
    private ForumMapper forumMapper;

    @InjectMocks
    private ForumServiceImpl forumService;

    private Forum forum;

    private Forum forum1;


    private ForumDTO forumDTO;

    private ForumDTO forumDTO1;


    @BeforeEach
    void setup(){
        forum = new Forum(15L,"test","test","test", Instant.now(),null);
        forum1 = new Forum(16L,"test1","test1","test1", Instant.now(),null);
        forumDTO = new ForumDTO(15L,"test","test","test", Instant.now(),null);
        forumDTO1 = new ForumDTO(16L,"test1","test1","test1", Instant.now(),null);


    }

    @Test
    public void whenFinOneById_thenReturnOptionalForumDTO(){
        when(forumRepository.findById(15L)).thenReturn(Optional.of(forum));
        when(forumMapper.toDto(forum)).thenReturn(forumDTO);

        Optional<ForumDTO> forumRecover = forumService.finOneById(15L);
        Assertions.assertNotNull(forumRecover.orElse(null));
    }

    @Test
    public void whenSave_thenReturnForumDTO(){
        when(forumMapper.toDto(forum1)).thenReturn(forumDTO1);
        when(forumMapper.toEntity(forumDTO1)).thenReturn(forum1);
        when(forumRepository.save(forum1)).thenReturn(forum1);

         ForumDTO forumDTO2 =  forumService.save(forumDTO1);

         Assertions.assertEquals(forumDTO2.getId(), 16L);

    }
}

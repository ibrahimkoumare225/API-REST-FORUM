package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.ForumDTO;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    ForumDTO save (ForumDTO forumDTO);


    Optional<ForumDTO> finOneById(Long id);
    Optional<ForumDTO> finOneBySlug(String slug);

    List<ForumDTO> findAll();
}

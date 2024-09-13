package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    List<SujetDTO> findAll();

    Optional<SujetDTO> findOne(Long id);

    SujetDTO saveSujet(SujetDTO sujetDTO);

    List<SujetDTO> findByForumId(Long forumId);
}

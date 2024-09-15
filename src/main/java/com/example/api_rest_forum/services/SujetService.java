package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {


    SujetDTO createByIdForum(SujetDTO subjectDTO,Long id);

    SujetDTO createBySlugForum(SujetDTO subjectDTO,String slug);

    List<SujetDTO> findAll();

    Optional<SujetDTO> findById(Long id);

    Optional<SujetDTO> findBySlug(String slug);

    List<SujetDTO> findByForumId(Long id);

    List<SujetDTO> findByForumSlug(String slug);
}

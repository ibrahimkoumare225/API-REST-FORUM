package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    List<SujetDTO> findAll(SujetDTO sujetDTO);

    Optional<SujetDTO> findOne(Long id);
}

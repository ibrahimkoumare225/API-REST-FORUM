package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Sujet;
import com.example.api_rest_forum.repository.SujetRepository;
import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.SujetDTO;
import com.example.api_rest_forum.services.mappers.SujetMapper;
import com.example.api_rest_forum.services.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        log.debug("Saving sujet {}", sujetDTO);
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        return sujetMapper.toDto(sujetRepository.save(sujet));
    }

    @Override
    public List<SujetDTO> findAll() {
        log.debug("Finding all sujet");
        return sujetRepository.findAll().stream().map(sujetMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<SujetDTO> findOne(Long id) {
        return sujetRepository.findById(id).map(sujetMapper::toDto);
    }

    @Override
    public SujetDTO saveSujet(SujetDTO sujetDTO) {
        final String slug = SlugifyUtils.generate(sujetDTO.getForum().toString());
        sujetDTO.setSlug(slug);
        return save(sujetDTO);
    }

    @Override
    public List<SujetDTO> findByForumId(Long forumId) {
        log.debug("Finding sujets by forum id {}", forumId);
        return sujetRepository.findByForumId(forumId).stream().map(sujetMapper::toDto).collect(Collectors.toList());
    }
}

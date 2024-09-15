package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Sujet;
import com.example.api_rest_forum.repository.SujetRepository;
import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;
import com.example.api_rest_forum.services.mappers.SujetMapper;
import com.example.api_rest_forum.services.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final ForumService forumService;
    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO createByIdForum(SujetDTO subjectDTO,Long id) {
        log.debug("Request to create by id forum  : {}", subjectDTO);
        Optional<ForumDTO> forumDTO = forumService.finOneById(id);
        subjectDTO.setSlug(SlugifyUtils.generate(subjectDTO.getTitle()));
        if (forumDTO.isEmpty()){
            return null;
        }
        subjectDTO.setForum(forumDTO.get());
        return sujetMapper.toDto(sujetRepository.save(sujetMapper.toEntity(subjectDTO)));
    }

    @Override
    public SujetDTO createBySlugForum(SujetDTO subjectDTO, String slug) {
        log.debug("Request to create by slug : {}", subjectDTO);
        Optional<ForumDTO> forumDTO = forumService.finOneBySlug(slug);
        subjectDTO.setSlug(SlugifyUtils.generate(subjectDTO.getTitle()));
        if (forumDTO.isEmpty()){
            return null;
        }
        subjectDTO.setForum(forumDTO.get());
        return sujetMapper.toDto(sujetRepository.save(sujetMapper.toEntity(subjectDTO)));
    }


    @Override
    public List<SujetDTO> findAll() {
        log.debug("Request to get all Subject");
        return sujetRepository.findAll().stream().map(sujetMapper::toDto).toList();
    }

    @Override
    public Optional<SujetDTO> findById(Long id) {
        log.debug("Request to get Subject by id : {}", id);
        return sujetRepository.findById(id).map(sujetMapper::toDto);
    }

    @Override
    public Optional<SujetDTO> findBySlug(String slug) {
        log.debug("Request to get Subject by slug : {}", slug);
        return sujetRepository.findBySlug(slug).map(sujetMapper::toDto);
    }

    @Override
    public List<SujetDTO> findByForumId(Long id) {
        log.debug("Request to get Subject by forum id : {}", id);
        List<SujetDTO> subjectDTOList = new  ArrayList<>();
        findAll().forEach(subjectDTO -> {
            if(subjectDTO.getForum().getId().equals(id)){
                subjectDTOList.add(subjectDTO);
            }
        });
        return subjectDTOList;
    }

    @Override
    public List<SujetDTO> findByForumSlug(String slug) {
        log.debug("Request to get Subject by forum slug : {}", slug);
        List<SujetDTO> subjectDTOList = new  ArrayList<>();
        findAll().forEach(subjectDTO -> {
            if(subjectDTO.getForum().getSlug().equals(slug)){
                subjectDTOList.add(subjectDTO);
            }
        });
        return subjectDTOList;
    }
}
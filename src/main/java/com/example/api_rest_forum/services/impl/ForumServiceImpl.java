package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.repository.ForumRepository;
import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.mappers.ForumMapper;
import com.example.api_rest_forum.services.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save Forum : {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setSlug(SlugifyUtils.generate(forum.getTitle()));
        Forum saveForum = forumRepository.save(forum);
        return forumMapper.toDto(saveForum);
    }


    @Override
    public Optional<ForumDTO> finOneById(Long id) {
        log.debug("Request to get Forum by id : {}", id);
        return forumRepository.findById(id).map(forum -> {
            return forumMapper.toDto(forum);
        });

    }

    @Override
    public Optional<ForumDTO> finOneBySlug(String slug) {
        log.debug("Request to get Forum by slug : {}", slug);
        return forumRepository.findBySlug(slug).map(forum -> {
            return forumMapper.toDto(forum);
        });
    }

    @Override
    public List<ForumDTO> findAll() {
        log.debug("Request to get all Forum");
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.toDto(forum);
        }).toList();
    }
}

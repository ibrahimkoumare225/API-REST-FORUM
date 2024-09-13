package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.repository.ForumRepository;
import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.mappers.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ForumServiceImpl implements ForumService{

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Saving forum {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setCreatedDate(Instant.now());
        forum = forumRepository.save(forum);
        return forumMapper.toDto(forum) ;
    }

    @Override
    public List<ForumDTO> findAll() {
<<<<<<< HEAD
        log.debug("Finding all forum");
=======
>>>>>>> 5701f85 (Mise en place de l'Api Rest pour forum)
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.toDto(forum);
        }).toList();
    }

    @Override
    public Optional<ForumDTO> findOne(Long id) {
        log.debug("find one forum by id {}", id);
        return forumRepository.findById(id).map(forum -> {
            return forumMapper.toDto(forum);
        });
    }
}

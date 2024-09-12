package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Forum;
import com.example.api_rest_forum.repository.ForumRepository;
import com.example.api_rest_forum.services.ForumService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.mappers.ForumMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ForumServiceImpl implements ForumService{

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        Forum forum = forumMapper.toEntity(forumDTO);
        forum = forumRepository.save(forum);
        return forumMapper.toDto(forum) ;
    }

    @Override
    public List<ForumDTO> findAll(ForumDTO forumDTO) {
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.toDto(forum);
        }).toList();
    }

    @Override
    public Optional<ForumDTO> findOne(Long id) {
        return forumRepository.findById(id).map(forum -> {
            return forumMapper.toDto(forum);
        });
    }
}

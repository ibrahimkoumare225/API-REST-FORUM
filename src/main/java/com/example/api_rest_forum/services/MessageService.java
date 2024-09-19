package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    MessageDTO saveMessageByIdSubject(MessageDTO messageDTO, Long id);

    MessageDTO saveMessageBySlug(MessageDTO messageDTO, String slug);

    List<MessageDTO> findAll();

    List<MessageDTO> getAllMessageByIdSubject(Long id);

    List<MessageDTO> getAllMessageBySlugSubject(String slug);
}

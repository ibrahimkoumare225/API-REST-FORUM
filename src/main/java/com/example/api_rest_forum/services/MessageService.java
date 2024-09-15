package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    MessageDTO saveMessageById(MessageDTO messageDTO, Long id);

    MessageDTO saveMessageBySlug(MessageDTO messageDTO, String slug);

    List<MessageDTO> findAll();

    List<MessageDTO> getAllMessageByIdSubject(Long id);

    List<MessageDTO> getAllMessageBySlugSubject(String slug);
}

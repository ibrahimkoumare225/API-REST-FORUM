package com.example.api_rest_forum.services;

import com.example.api_rest_forum.services.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {
   MessageDTO save(MessageDTO messageDTO);

    List<MessageDTO> findAll(MessageDTO messageDTO);

    Optional<MessageDTO> findOne(Long id);
}

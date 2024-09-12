package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Message;
import com.example.api_rest_forum.repository.MessageRepository;
import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.mappers.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDTO> findAll(MessageDTO messageDTO) {
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

    @Override
    public Optional<MessageDTO> findOne(Long id) {
        return messageRepository.findById(id).map(message -> {
            return messageMapper.toDto(message);
        });
    }
}

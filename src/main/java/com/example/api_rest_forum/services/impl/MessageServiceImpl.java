package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Message;
import com.example.api_rest_forum.repository.MessageRepository;
import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.mappers.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Saving message {}", messageDTO);
        Message message = messageMapper.toEntity(messageDTO);
        message.setCreatedDate(Instant.now());
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDTO> findAll() {
        log.debug("Finding all message");
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

    @Override
    public Optional<MessageDTO> findOne(Long id) {
        log.debug("find one message by id {}", id);
        return messageRepository.findById(id).map(message -> {
            return messageMapper.toDto(message);
        });
    }
}

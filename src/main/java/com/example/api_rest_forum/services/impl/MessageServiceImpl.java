package com.example.api_rest_forum.services.impl;

import com.example.api_rest_forum.modeles.Message;
import com.example.api_rest_forum.repository.MessageRepository;
import com.example.api_rest_forum.repository.SujetRepository;
import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;
import com.example.api_rest_forum.services.mappers.MessageMapper;
import com.example.api_rest_forum.services.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final SujetService sujetService;

    @Override
    public MessageDTO saveMessageById(MessageDTO messageDTO, Long id) {
        log.debug("Request to save by id: {}", messageDTO);

        Optional<SujetDTO> subjectDTO = sujetService.findById(id);
        if (subjectDTO.isEmpty()){
            return null;
        }
        messageDTO.setSujet(subjectDTO.get());
        messageDTO.setCreatedDate(Instant.now());
        Message message = messageMapper.toEntity(messageDTO);
        message.setSlug(SlugifyUtils.generate(message.getCreatedDate().toString()));
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }


    @Override
    public MessageDTO saveMessageBySlug(MessageDTO messageDTO, String slug) {
        log.debug("Request to save by slug: {}", messageDTO);
        Optional<SujetDTO> subjectDTO = sujetService.findBySlug(slug);
        if (subjectDTO.isEmpty()){
            return null;
        }
        messageDTO.setSujet(subjectDTO.get());
        messageDTO.setCreatedDate(Instant.now());
        Message message = messageMapper.toEntity(messageDTO);
        message.setSlug(SlugifyUtils.generate(message.getCreatedDate().toString()));
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }
    @Override
    public List<MessageDTO> findAll() {
        log.debug("Request to found all message");
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

    @Override
    public List<MessageDTO> getAllMessageByIdSubject(Long id) {
        log.debug("Request to get all message by subject id : {}", id);
        List<MessageDTO> listMessage = new ArrayList<>();
        List<MessageDTO> messages = findAll();
        for (MessageDTO message : messages){
            if (message.getSujet().getId().equals(id)){
                listMessage.add(message);
            }
        }
        System.out.println(listMessage);
        return listMessage;
    }

    @Override
    public List<MessageDTO> getAllMessageBySlugSubject(String slug) {
        log.debug("Request to get all message by subject slug : {}", slug);
        List<MessageDTO> listMessage = new ArrayList<>();
        List<MessageDTO> messages = findAll();
        for (MessageDTO message : messages){
            if (Objects.equals(message.getSujet().getSlug(), slug)){
                listMessage.add(message);
            }
        }
        System.out.println(listMessage);
        return listMessage;
    }
}

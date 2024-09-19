package com.example.api_rest_forum.service.impl;

import com.example.api_rest_forum.repository.MessageRepository;
import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.SujetService;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;
import com.example.api_rest_forum.services.impl.MessageServiceImpl;
import com.example.api_rest_forum.services.impl.SujetServiceImpl;
import com.example.api_rest_forum.services.mappers.MessageMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void whenSaveMessageById_thenReturnMessageDTO(){
        //given
        //when
        //when(sujetService.findById(10L)).thenReturn(Optional.of(new SujetDTO()));
        MessageDTO messageDTO = messageService.saveMessageByIdSubject(new MessageDTO(),10L);

        //then
    }
}

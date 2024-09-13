package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/messages")
@RestController
public class MessageRessource {

    private final MessageService messageService;

    @PostMapping
    ResponseEntity<MessageDTO> save(@RequestBody MessageDTO message){
        log.debug("REST Request to save forum ");
        return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<?>getOneMessage(@PathVariable Long id){
        log.debug("REST Request to get one forum by id {} ",id);
        Optional<MessageDTO>message = messageService.findOne(id);
        if(message.isPresent()){
            return new ResponseEntity<>(message,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Message not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    List<MessageDTO> messages(){
        log.debug("REST Request to get All forum ");
        return messageService.findAll();
    }
}

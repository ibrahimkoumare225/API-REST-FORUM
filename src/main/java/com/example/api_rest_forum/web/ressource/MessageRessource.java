package com.example.api_rest_forum.web.ressource;

import com.example.api_rest_forum.services.MessageService;
import com.example.api_rest_forum.services.dto.ForumDTO;
import com.example.api_rest_forum.services.dto.MessageDTO;
import com.example.api_rest_forum.services.dto.SujetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping("/{id}")
    @ApiResponse(responseCode = "201", description= "Request to save message")
    @Operation(summary = "message new save", description = "this endpoint allow to save message")
    public ResponseEntity<MessageDTO> saveMessageById(@RequestBody MessageDTO messageDTO, @PathVariable Long id){
        log.debug("REST Request to save by id {}", messageDTO);
        return new ResponseEntity<>(messageService.saveMessageById(messageDTO, id), HttpStatus.CREATED);
    }

    @PostMapping("/slug/{slug}")
    @ApiResponse(responseCode = "201", description= "Request to save message")
    @Operation(summary = "message new save", description = "this endpoint allow to save message")
    public ResponseEntity<MessageDTO> saveMessageBySlug(@RequestBody MessageDTO messageDTO, @PathVariable String slug){
        log.debug("REST Request to save by slug {}", messageDTO);
        return new ResponseEntity<>(messageService.saveMessageBySlug(messageDTO, slug), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "get all message", description = "this endpoint allow to get all message")
    public List<MessageDTO> getAllMessages(){
        log.debug("REST Request to get all");
        return messageService.findAll();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get message"),
            @ApiResponse(responseCode = "404", description = "message not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get all message by id subject", description = "this endpoint allow to get all message by id subject")
    public List<MessageDTO> getAllMessageByIdSubject(@PathVariable Long id){
        log.debug("REST Request to get all message subject");
        return messageService.getAllMessageByIdSubject(id);
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Request to get message by slug"),
            @ApiResponse(responseCode = "404", description = "message not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "get all message by slug subject", description = "this endpoint allow to get all message by slug subject")
    public List<MessageDTO> getAllMessageSubjectBySlug(@PathVariable String slug){
        log.debug("REST Request to get all message subject by slug");
        return messageService.getAllMessageBySlugSubject(slug);
    }
}